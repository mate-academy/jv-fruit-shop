package db;

import service.FileReaderService;
import service.FileWriterService;
import service.impl.FileReaderServiceImpl;
import service.impl.FileWriterServiceImpl;

public class StorageImpl implements Storage {
    private static final String STORAGE_PATH = "src/main/resources/storage.csv";
    private static final FileWriterService fileWriter = new FileWriterServiceImpl();
    private static final FileReaderService readFile = new FileReaderServiceImpl();

    @Override
    public void transferToStorage(String data) {
        fileWriter.writeToFile(data, STORAGE_PATH);
    }

    @Override
    public String getFromStorage() {
        return readFile.read(STORAGE_PATH);
    }
}
