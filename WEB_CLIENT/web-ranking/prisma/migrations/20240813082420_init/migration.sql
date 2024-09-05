-- RedefineTables
PRAGMA defer_foreign_keys=ON;
PRAGMA foreign_keys=OFF;
CREATE TABLE "new_Contributor" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" TEXT NOT NULL,
    "points" DECIMAL,
    "editFiles" INTEGER,
    "editLines" INTEGER NOT NULL,
    "deletedLines" INTEGER NOT NULL,
    "repoId" INTEGER NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL,
    CONSTRAINT "Contributor_repoId_fkey" FOREIGN KEY ("repoId") REFERENCES "Repos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);
INSERT INTO "new_Contributor" ("createdAt", "deletedLines", "editFiles", "editLines", "id", "name", "points", "repoId", "updatedAt") SELECT "createdAt", "deletedLines", "editFiles", "editLines", "id", "name", "points", "repoId", "updatedAt" FROM "Contributor";
DROP TABLE "Contributor";
ALTER TABLE "new_Contributor" RENAME TO "Contributor";
CREATE TABLE "new_Repos" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "url" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "designNote" INTEGER,
    "codeNote" INTEGER,
    "files" INTEGER,
    "lines" INTEGER NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL
);
INSERT INTO "new_Repos" ("codeNote", "createdAt", "designNote", "files", "id", "lines", "name", "updatedAt", "url") SELECT "codeNote", "createdAt", "designNote", "files", "id", "lines", "name", "updatedAt", "url" FROM "Repos";
DROP TABLE "Repos";
ALTER TABLE "new_Repos" RENAME TO "Repos";
CREATE UNIQUE INDEX "Repos_url_key" ON "Repos"("url");
CREATE UNIQUE INDEX "Repos_name_key" ON "Repos"("name");
PRAGMA foreign_keys=ON;
PRAGMA defer_foreign_keys=OFF;
