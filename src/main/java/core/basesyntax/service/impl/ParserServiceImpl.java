package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            transactions.add(getTransactionFromLine(line));
        }
        return transactions;
    }

    private FruitTransaction getTransactionFromLine(String lineFromData) {
        String[] splittedData = lineFromData.split(",");
        FruitTransaction transaction = new FruitTransaction();
        transaction.setOperation(getOperationByValue(splittedData[0]));
        transaction.setFruit(new Fruit(splittedData[1]));
        transaction.setQuantity(Integer.parseInt(splittedData[2]));
        return transaction;
    }

    private FruitTransaction.Operation getOperationByValue(String lineFromData) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(operation -> operation.getOperation().equals(lineFromData))
                .findFirst()
                .get();
    }
}
