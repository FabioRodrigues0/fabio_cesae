/*
  Warnings:

  - You are about to alter the column `contribution` on the `ContributorRepos` table. The data in that column could be lost. The data in that column will be cast from `Decimal` to `Float`.
  - You are about to alter the column `points` on the `ContributorRepos` table. The data in that column could be lost. The data in that column will be cast from `Decimal` to `Float`.

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
