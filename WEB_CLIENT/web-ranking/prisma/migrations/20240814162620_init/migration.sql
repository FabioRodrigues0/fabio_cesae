/*
  Warnings:

  - You are about to drop the column `contributorId` on the `ContributorRepos` table. All the data in the column will be lost.
  - Added the required column `contributorName` to the `ContributorRepos` table without a default value. This is not possible if the table is not empty.

*/
-- RedefineTables
PRAGMA defer_foreign_keys=ON;
PRAGMA foreign_keys=OFF;
CREATE TABLE "new_ContributorRepos" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "points" DECIMAL,
    "contribution" DECIMAL NOT NULL,
    "editLines" INTEGER NOT NULL,
    "deletedLines" INTEGER NOT NULL,
    "repoId" INTEGER NOT NULL,
    "contributorName" TEXT NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL,
    CONSTRAINT "ContributorRepos_repoId_fkey" FOREIGN KEY ("repoId") REFERENCES "Repos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT "ContributorRepos_contributorName_fkey" FOREIGN KEY ("contributorName") REFERENCES "Contributor" ("name") ON DELETE RESTRICT ON UPDATE CASCADE
);
INSERT INTO "new_ContributorRepos" ("contribution", "createdAt", "deletedLines", "editLines", "id", "points", "repoId", "updatedAt") SELECT "contribution", "createdAt", "deletedLines", "editLines", "id", "points", "repoId", "updatedAt" FROM "ContributorRepos";
DROP TABLE "ContributorRepos";
ALTER TABLE "new_ContributorRepos" RENAME TO "ContributorRepos";
PRAGMA foreign_keys=ON;
PRAGMA defer_foreign_keys=OFF;
