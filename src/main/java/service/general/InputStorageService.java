package service.general;

import storage.InputStorage;

public interface InputStorageService {
    void saveInput(String filePath);

    InputStorage getStorageData();
}
