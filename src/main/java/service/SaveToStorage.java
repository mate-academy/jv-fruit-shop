package service;

import java.util.Map;
import model.FruitType;

public interface SaveToStorage {
    void writeToDataBase(Map<FruitType, Integer> listCountedFruit);
}
