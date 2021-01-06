package core.basesyntax.service.interfaces;

public interface FruitService {
    void saveDataToStorage(String[] record);

    String getDataFromStorage();
}
