package core.basesyntax.storage;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Operation;
import java.util.List;
import java.util.Map;

public class ProcessingData {
    private static final String ABBREVIATION_BALANCE = "b";
    private static final String ABBREVIATION_PURCHASE = "p";
    private static final String ABBREVIATION_SUPPLY = "s";
    private static final String ABBREVIATION_RETURN = "r";
    private final StorageDaoImpl storageOperation = new StorageDaoImpl();

    public void recognitionData(Map<Operation, Map<String, List<Integer>>> fruitMaps,
                                String operationType, String rowFromOperationList) {
        switch (operationType) {
            case ABBREVIATION_BALANCE:
                storageOperation.addValueToStorage(fruitMaps, Operation.BALANCE,
                        storageOperation.getFruits(rowFromOperationList),
                        storageOperation.getQuantity(rowFromOperationList));
                break;
            case ABBREVIATION_PURCHASE:
                storageOperation.addValueToStorage(fruitMaps, Operation.PURCHASE,
                        storageOperation.getFruits(rowFromOperationList),
                        storageOperation.getQuantity(rowFromOperationList));
                break;
            case ABBREVIATION_SUPPLY:
                storageOperation.addValueToStorage(fruitMaps, Operation.SUPPLY,
                        storageOperation.getFruits(rowFromOperationList),
                        storageOperation.getQuantity(rowFromOperationList));
                break;
            case ABBREVIATION_RETURN:
                storageOperation.addValueToStorage(fruitMaps, Operation.RETURN,
                        storageOperation.getFruits(rowFromOperationList),
                        storageOperation.getQuantity(rowFromOperationList));
                break;
            default:
                throw new RuntimeException("Can't define the type of operationType");
        }
    }
}

