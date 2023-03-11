package service.general;

import java.util.List;

public interface InputStorageService {

    void saveInput(String filePath);

    List<String> getStorageData();
}
