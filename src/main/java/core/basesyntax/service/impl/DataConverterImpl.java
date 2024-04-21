package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private static final int FIRST_LINE = 1;
    private static final int OPERATION_CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String COMMA = ",";
    private final List<FruitTransaction> fruitTransactions;
    private String[] dataArray;
    private FruitTransaction.Operation operation;

    public DataConverterImpl() {
        this.fruitTransactions = new ArrayList<>();
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactionData) {
        if (transactionData.isEmpty()) {
            throw new RuntimeException("CSV file is empty!" + transactionData);
        }
        if (!transactionData.get(0).equals("type,fruit,quantity")) {
            throw new IllegalArgumentException("Incorrect data format!" + transactionData);
        }
        return transactionData.stream()
                .skip(FIRST_LINE)
                .map(line -> {
                    dataArray = line.split(COMMA);
                    return new FruitTransaction(
                            operation.fromCode(dataArray[OPERATION_CODE_INDEX]),
                            dataArray[FRUIT_INDEX],
                            Integer.parseInt(dataArray[QUANTITY_INDEX]));
                })
                .collect(Collectors.toList());
    }
}
