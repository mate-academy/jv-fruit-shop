package service;

import java.util.Map;
import model.FruitType;

public interface WriteToStorage {
    void writeToDataBase(Map<FruitType, Integer> listCountedFruit);
}
