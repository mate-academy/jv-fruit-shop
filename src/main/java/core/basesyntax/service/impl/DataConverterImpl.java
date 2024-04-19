package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverter {
    private final String splitBy = ",";
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
                .skip(1)
                .map(line -> {
                    dataArray = line.split(splitBy);
                    return new FruitTransaction(
                            operation.fromCode(dataArray[0]),
                            dataArray[1],
                            Integer.parseInt(dataArray[2]));
                })
                .collect(Collectors.toList());
    }
}
