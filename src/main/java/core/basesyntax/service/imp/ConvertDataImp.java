package core.basesyntax.service.imp;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ConvertDataImp implements ConvertData {
    private final String csvSplitBy = ";";
    private final List<FruitTransaction> fruitTransactions;
    private String[] tempArrayString;
    private FruitTransaction.Operation operation;

    public ConvertDataImp() {
        this.fruitTransactions = new ArrayList<>();
    }

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> transactionData) {
        if (transactionData.isEmpty()) {
            throw new RuntimeException("CSV file is empty");
        }
        if (!transactionData.get(0).equals("type;fruit;quantity")) {
            throw new IllegalArgumentException("Incorrect text format");
        }
        return transactionData.stream()
                .skip(1)
                .map(line -> {
                    tempArrayString = line.split(csvSplitBy);
                    return new FruitTransaction(
                    FruitTransaction.Operation.fromCode(tempArrayString[0]),
                    tempArrayString[1],
                    Integer.parseInt(tempArrayString[2])
                    );
                })
                .collect(Collectors.toList());
    }
}
