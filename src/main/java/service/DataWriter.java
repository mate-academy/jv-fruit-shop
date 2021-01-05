package service;

import java.util.Map;
import model.Fruit;

public interface DataWriter {
    void writeToFile(Map<Fruit, Integer> fruitReport, String fileTo);
}
