package service;

import java.util.List;
import model.Fruit;

public interface Reader {
    String read();

    List<Fruit> getFromCsvRow(String line);
}
