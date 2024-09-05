-- CreateTable
CREATE TABLE "Repos" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "url" TEXT NOT NULL,
    "name" TEXT NOT NULL,
    "designNote" INTEGER,
    "codeNote" INTEGER,
    "files" INTEGER NOT NULL,
    "lines" INTEGER NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL
);

-- CreateTable
CREATE TABLE "Contributor" (
    "id" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
    "name" TEXT NOT NULL,
    "points" DECIMAL NOT NULL,
    "editFiles" INTEGER NOT NULL,
    "editLines" INTEGER NOT NULL,
    "deletedLines" INTEGER NOT NULL,
    "repoId" INTEGER NOT NULL,
    "createdAt" DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
    "updatedAt" DATETIME NOT NULL,
    CONSTRAINT "Contributor_repoId_fkey" FOREIGN KEY ("repoId") REFERENCES "Repos" ("id") ON DELETE RESTRICT ON UPDATE CASCADE
);

-- CreateIndex
CREATE UNIQUE INDEX "Repos_url_key" ON "Repos"("url");

-- CreateIndex
CREATE UNIQUE INDEX "Repos_name_key" ON "Repos"("name");
