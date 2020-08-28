package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.StorageOperation;
import core.basesyntax.operations.SupplyAndReturnOperation;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    public static Map<String, Integer> fruitStorage;
    public static Map<String, LocalDate> expiration;

    public Map<String, Integer> createFruitStorage(List<Operation> operations) {
        fruitStorage = new HashMap<>();
        expiration = new HashMap<>();
        for (Operation operation : operations) {
            if (operation.getType().equals("s") || operation.getType().equals("r")) {
                StorageOperation storageOperation = new SupplyAndReturnOperation();
                storageOperation.doStorageOperation(operation);
            }
            if (operation.getType().equals("b")) {
                StorageOperation storageOperation = new PurchaseOperation();
                storageOperation.doStorageOperation(operation);
            }
        }
        return fruitStorage;
    }

}
