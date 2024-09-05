/*
  Warnings:

  - You are about to drop the column `deletedLines` on the `Contributor` table. All the data in the column will be lost.
  - You are about to drop the column `editFiles` on the `Contributor` table. All the data in the column will be lost.
  - You are about to drop the column `editLines` on the `Contributor` table. All the data in the column will be lost.
  - You are about to drop the column `points` on the `Contributor` table. All the data in the column will be lost.
  - You are about to drop the column `repoId` on the `Contributor` table. All the data in the column will be lost.
  - You are about to drop the column `files` on the `Repos` table. All the data in the column will be lost.

*/
-- CreateTable
CREATE TABLE "ContributorRepos" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "points" DECIMAL,
    "contribution" DECIMAL NOT NULL,
    "editLines" INTEGER NOT NULL,
    "deletedLines" INTEGER NOT NULL,
    "repoId" INTEGER NOT NULL,
    "contributorId" INTEGER NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL,
    CONSTRAINT "ContributorRepos_repoId_fkey" FOREIGN KEY ("repoId") REFERENCES "Repos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE,
    CONSTRAINT "ContributorRepos_contributorId_fkey" FOREIGN KEY ("contributorId") REFERENCES "Contributor" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);

-- RedefineTables
PRAGMA defer_foreign_keys=ON;
PRAGMA foreign_keys=OFF;
CREATE TABLE "new_Contributor" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" TEXT NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL
);
INSERT INTO "new_Contributor" ("createdAt", "id", "name", "updatedAt") SELECT "createdAt", "id", "name", "updatedAt" FROM "Contributor";
DROP TABLE "Contributor";
ALTER TABLE "new_Contributor" RENAME TO "Contributor";
CREATE TABLE "new_Repos" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "url" TEXT,
    "name" TEXT NOT NULL,
    "course" TEXT,
    "designNote" INTEGER,
    "codeNote" INTEGER,
    "lines" INTEGER NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL
);
INSERT INTO "new_Repos" ("codeNote", "createdAt", "designNote", "id", "lines", "name", "updatedAt", "url") SELECT "codeNote", "createdAt", "designNote", "id", "lines", "name", "updatedAt", "url" FROM "Repos";
DROP TABLE "Repos";
ALTER TABLE "new_Repos" RENAME TO "Repos";
CREATE UNIQUE INDEX "Repos_url_key" ON "Repos"("url");
CREATE UNIQUE INDEX "Repos_name_key" ON "Repos"("name");
PRAGMA foreign_keys=ON;
PRAGMA defer_foreign_keys=OFF;
