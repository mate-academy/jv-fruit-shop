package service.general;

public interface DataStorageService {
    void putValue(String key, Integer value);

    Integer getValue(String key);
}
