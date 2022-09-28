package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.Operation;

import java.util.List;
import java.util.stream.Collectors;

public class InputDataServiceImpl implements InputDataService{
    @Override
    public List<FruitTransaction> stringToFruitTransactionConverter(List<String> inputText) {
        return inputText.stream()
                .map(this::getFromString)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFromString(String line) {
        String[] fields = line.split(",");
        Operation operation = Operation.getEnumByTitle(fields[0]);
        String fruitName = fields[1];
        int quantity = Integer.parseInt(fields[2]);
        return new FruitTransaction(operation, fruitName, quantity);
    }
}
