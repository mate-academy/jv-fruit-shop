package service;

import model.Fruit;

public interface DataBaseService {
    int read(Fruit key);
    void write(Fruit key, Integer value);
}
