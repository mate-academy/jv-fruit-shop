package services;

import java.util.List;
import java.util.Set;
import model.Fruit;
import model.FruitRecord;

public interface ParseService {
    List<FruitRecord> parseFromCsv(String datInString);

    String parseIntoCsv(Set<Fruit> datInString);
}
