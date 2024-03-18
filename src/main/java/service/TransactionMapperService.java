package service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import model.FruitTransaction;

public class TransactionMapperService {
    private static final String TITLE = "type,fruit,quantity";
    private static final String DATA_SEPARATOR = ",";
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private final Map<String, FruitTransaction.Operation> operationConverterMap = Map.of(
            "b", FruitTransaction.Operation.BALANCE,
            "s", FruitTransaction.Operation.SUPPLY,
            "p", FruitTransaction.Operation.PURCHASE,
            "r", FruitTransaction.Operation.RETURN
    );

    public List<FruitTransaction> stringToFruitTransaction(String takenData) {
        return Arrays.stream(takenData.split(System.lineSeparator()))
                .filter(str -> !str.equals(TITLE))
                .map(str -> {
                    String[] parts = str.split(DATA_SEPARATOR);
                    return new FruitTransaction(operationConverterMap.get(parts[OPERATION]),
                            parts[FRUIT],
                            Integer.parseInt(parts[QUANTITY]));
                })
                .collect(Collectors.toList());
    }
}
