package services.readfromfile;

import storage.StorageTransactions;

public interface ReadingFromFile {
    StorageTransactions readingFromFile(String filePath);
}
