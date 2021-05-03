package model.dto;

import java.util.Map;
import model.Fruit;

public interface WriteToFile {
    void writeToFile(Map<Fruit, Integer> map);
}
