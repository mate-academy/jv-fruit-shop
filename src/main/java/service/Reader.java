package service;

import model.Fruit;

import java.util.List;

public interface Reader {
    String read();

    List<Fruit> getFromCsvRow(String line);
}
