package service;

import java.util.List;
import model.Fruit;

public interface ReaderService {
    List<Fruit> readFromFile(String fileName);
}
