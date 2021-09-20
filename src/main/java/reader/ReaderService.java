package reader;

import model.Fruit;

import java.util.List;

public interface ReaderService {
   List<Fruit> read(String path);
}
