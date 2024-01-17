package core.basesyntax.process;

import core.basesyntax.storage.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class RawDataHandler {
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public List<FruitTransaction> parseRawData(List<String> list) {
        return list.stream()
                .map(element -> element.split(","))
                .map(arr -> new FruitTransaction(arr[FRUIT_TYPE_INDEX],
                        Integer.parseInt(arr[QUANTITY_INDEX]),
                        FruitTransaction.Operation.getByCode(arr[OPERATION_TYPE_INDEX])))
                .collect(Collectors.toList());
    }
}
