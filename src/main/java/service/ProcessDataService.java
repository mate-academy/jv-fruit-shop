package service;

import java.util.List;
import model.Fruit;

public interface ProcessDataService {
    List<Fruit> processData(List<Fruit> parsedData);
}
