package service.writereadcsv;

import java.util.List;
import model.Fruit;

public interface FruitServiceReaderCsv {
    List<Fruit> read(String fruitName);

    List<Fruit> readAll();
}
