package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.NegativeDataInFileException;

import java.util.HashMap;
import java.util.Map;

public class StorageDaoImpl implements StorageDao {
    @Override
    public HashMap<String, Integer> add(FruitTransactionDto dto) {
        Storage.fruitsQuantity.put(dto.fruitName(), dto.quantity());
        return Storage.fruitsQuantity;
    }

    @Override
    public HashMap<String, Integer> get(FruitTransactionDto dto) {
        for (Map.Entry<String, Integer> fruit : Storage.fruitsQuantity.entrySet()) {
            if (fruit.getKey().equals(dto.fruitName())) {
                return Storage.fruitsQuantity;
            }
        }
        return null;
    }

    @Override
    public HashMap<String, Integer> change(FruitTransactionDto dto) {
        Integer existingQuantity = Storage.fruitsQuantity.get(dto.fruitName());
        if (existingQuantity != null) {
            Storage.fruitsQuantity.put(dto.fruitName(), dto.quantity());
        } else {
            throw new NegativeDataInFileException("Error! Quantity for fruit "
                    + dto.fruitName()
                    + " cannot be null");
        }
        return Storage.fruitsQuantity;
    }
}
