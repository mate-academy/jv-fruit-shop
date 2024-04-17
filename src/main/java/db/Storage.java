package db;

public interface Storage {
    void transferToStorage(String data);

    String getFromStorage();
}
