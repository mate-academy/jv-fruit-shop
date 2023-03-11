package service.impl;

import java.util.List;
import service.general.InputStorageService;
import service.general.ReaderService;
import storage.InputStorage;

public class InputStorageServiceImpl implements InputStorageService {

    @Override
    public List<String> getStorageData() {
        return InputStorage.getInputData();
    }

    public void saveInput(String filePath) {
        ReaderService reader = new ReaderServiceImpl();
        InputStorage.setInputData(reader.readFile(filePath));
    }
}
