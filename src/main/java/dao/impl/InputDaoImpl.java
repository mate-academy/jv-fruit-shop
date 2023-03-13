package dao.impl;

import dao.InputDao;
import java.util.List;
import storage.InputStorage;

public class InputDaoImpl implements InputDao {

    @Override
    public void saveInput(List<String> input) {
        InputStorage.setInputData(input);
    }

    @Override
    public List<String> getStorageData() {
        return InputStorage.getInputData();
    }
}
