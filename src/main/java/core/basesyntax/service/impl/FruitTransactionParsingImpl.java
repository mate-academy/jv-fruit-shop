package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitTransactionParsing;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitTransactionParsingImpl implements FruitTransactionParsing {

    private final Map<String, Operation> codeOperationMap;

    public FruitTransactionParsingImpl(Map<String, Operation> codeOperationMap) {
        this.codeOperationMap = codeOperationMap;
    }

    @Override
    public List<FruitTransaction> parse(List<String> lineList) {
        return lineList.stream()
                .filter(line -> !line.equals("type,fruit,quantity"))
                .map(this::parseFromString)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseFromString(String line) {
        String[] splitLine = line.split(",");

        if (splitLine.length != 3) {
            throw new RuntimeException("Incorrect data entry method");
        }

        Operation operation = new OperationIdentifierImpl(codeOperationMap).get(splitLine[0]);
        String name = splitLine[1];
        int quantity = Integer.parseInt(splitLine[2]);

        if (quantity <= 0) {
            throw new RuntimeException("Transaction quantity is lower then 0");
        }

        return new FruitTransaction(operation, name, quantity);
    }
}
