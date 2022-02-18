package dao;

import java.util.Map;

public interface WorkWithStorageDB {
    void addInStorage(String fruits,Integer quantity);

    Integer getFromStorage(String fruit);

    Map<String,Integer> getAllFromStorage();

}
