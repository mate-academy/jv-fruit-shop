package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> transaction) {
        return transaction.stream()
                .skip(1L)
                .map(this::convertToTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction convertToTransaction(String transaction) {
        String[] splitTransaction = transaction.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(FruitTransaction.Operation
                .getByAbbreviation(splitTransaction[0]));
        fruitTransaction.setFruit(splitTransaction[1]);
        fruitTransaction.setQuantity(Integer.parseInt(splitTransaction[2]));
        return fruitTransaction;
    }
}
