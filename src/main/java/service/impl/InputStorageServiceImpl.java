package service.impl;

import java.util.List;
import service.InputStorageService;
import storage.InputStorage;

public class InputStorageServiceImpl implements InputStorageService {

    @Override
    public void saveInput(List<String> input) {
        InputStorage.setInputData(input);
    }

    @Override
    public List<String> getStorageData() {
        return InputStorage.getInputData();
    }

}
