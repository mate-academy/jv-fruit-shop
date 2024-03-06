package service;

import java.util.List;
import model.Fruit;

public interface WriterService {
    void writeToFile(String pathToFile, List<Fruit> fruits);
}
