package core.basesyntax.service;

import java.time.LocalDate;

public interface StorageService {
    boolean supplyFruit(String fruitType,
                        int count, LocalDate expirationDate);

    boolean buyFruit(String fruitType,
                     int count, LocalDate purchaseDate);

    boolean returnFruit(String fruitType,
                        int count, LocalDate expirationDate);
}
