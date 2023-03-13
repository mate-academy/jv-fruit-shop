package dao;

import java.util.List;

public interface InputDao {

    void saveInput(List<String> input);

    List<String> getStorageData();
}
