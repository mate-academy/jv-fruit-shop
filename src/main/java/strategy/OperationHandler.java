package strategy;

import dao.StorageDao;
import model.FruitTransaction;

public interface OperationHandler {
    Integer operate(FruitTransaction order, StorageDao inStock);
}
