package service;

import model.Fruit;
import java.util.List;

public interface WriterService {
    void writeToFile(String pathToFile, List<Fruit> fruits);
}
