package service.impl;

import service.general.InputStorageService;
import service.general.ReaderService;
import storage.InputStorage;

public class InputStorageServiceImpl implements InputStorageService {
    private InputStorage currentStorage;

    public void saveInput(String filePath) {
        ReaderService reader = new ReaderServiceImpl();
        currentStorage = new InputStorage(reader.readFile(filePath));
    }

    @Override
    public InputStorage getStorageData() {
        return currentStorage;
    }
}
