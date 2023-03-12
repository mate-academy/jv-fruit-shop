package service;

import java.util.List;

public interface InputStorageService {

    void saveInput(List<String> input);

    List<String> getStorageData();
}
