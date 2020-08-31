package interfaces;

import model.Position;

public interface StorageService {
    void put(Position position);

    boolean buy(String fruitName, int quantity);
}
