package services;

import model.Fruit;
import model.FruitRecord;

import java.util.List;
import java.util.Set;

public interface ParseCSVService {
    List<FruitRecord> parseFromCsv(String datInString);

    String parseIntoCsv(Set<Fruit> datInString);
}
