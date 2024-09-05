/*
  Warnings:

  - You are about to drop the column `contributorGitId` on the `ContributorRepos` table. All the data in the column will be lost.
  - Added the required column `avatar_url` to the `ContributorRepos` table without a default value. This is not possible if the table is not empty.

*/
-- RedefineTables
PRAGMA defer_foreign_keys=ON;
PRAGMA foreign_keys=OFF;
CREATE TABLE "new_ContributorRepos" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "points" REAL,
    "contribution" REAL NOT NULL,
    "editLines" INTEGER NOT NULL,
    "deletedLines" INTEGER NOT NULL,
    "repoName" TEXT NOT NULL,
    "contributorName" TEXT NOT NULL,
    "avatar_url" TEXT NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL,
    CONSTRAINT "ContributorRepos_repoName_fkey" FOREIGN KEY ("repoName") REFERENCES "Repos" ("name") ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT "ContributorRepos_contributorName_fkey" FOREIGN KEY ("contributorName") REFERENCES "Contributor" ("name") ON DELETE RESTRICT ON UPDATE CASCADE
);
INSERT INTO "new_ContributorRepos" ("contribution", "contributorName", "createdAt", "deletedLines", "editLines", "id", "points", "repoName", "updatedAt") SELECT "contribution", "contributorName", "createdAt", "deletedLines", "editLines", "id", "points", "repoName", "updatedAt" FROM "ContributorRepos";
DROP TABLE "ContributorRepos";
ALTER TABLE "new_ContributorRepos" RENAME TO "ContributorRepos";
PRAGMA foreign_keys=ON;
PRAGMA defer_foreign_keys=OFF;
