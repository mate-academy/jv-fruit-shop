package interfaces;

import java.util.Map;
import model.Position;

public interface IStorageService {
    void put(Position position);

    Map buy(String fruitName, int quantity);
}
