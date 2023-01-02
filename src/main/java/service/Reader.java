package service;

import java.util.List;
import model.Fruit;

public interface Reader {
    List<Fruit> readerData(String fileName);
}
