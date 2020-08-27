package interfaces;

import java.util.Map;
import model.Fruit;

public interface StorageServiceInterface {
    void put(Fruit fruit);

    Map buy(String fruitName, int quantity);

    Map getReport();

    boolean isEnough(String key, int neededQuantity);
}
