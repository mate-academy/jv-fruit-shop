package service.writereadcsv;

import java.util.List;
import model.Fruit;

public interface FruitServiceWriterCsv {
    void write(Fruit fruit);

    void writeAll(List<Fruit> list);
}
