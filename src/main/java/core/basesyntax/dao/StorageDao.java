package core.basesyntax.dao;

import core.basesyntax.dto.FruitTransactionDto;
import java.util.HashMap;

public interface StorageDao {
    HashMap<String, Integer> add(FruitTransactionDto dto);

    HashMap<String, Integer> get(FruitTransactionDto dto);

    HashMap<String, Integer> change(FruitTransactionDto dto);
}
