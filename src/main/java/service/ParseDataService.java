package service;

import java.util.List;
import model.Fruit;

public interface ParseDataService {
    List<Fruit> parseData(List<String> list);
}
