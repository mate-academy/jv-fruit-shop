package core.basesyntax;

import core.basesyntax.model.FruitDto;
import core.basesyntax.operations.StorageOperation;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitStorage {
    public static Map<String, Integer> fruitStorage;
    public static Map<String, LocalDate> expiration;
    OperationProvider operationProvider = new OperationProvider();

    public Map<String, Integer> createFruitStorage(List<FruitDto> fruitDtos) {
        fruitStorage = new HashMap<>();
        expiration = new HashMap<>();
        for (FruitDto fruitDto : fruitDtos) {
            StorageOperation storageOperation = operationProvider
                    .getStorageOperation(fruitDto.getType());
            storageOperation.doStorageOperation(fruitDto);
        }
        return fruitStorage;
    }

}
