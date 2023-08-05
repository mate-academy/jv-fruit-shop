package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService<FruitTransaction> {
    private FruitTransaction transaction;

    public ParserServiceImpl(FruitTransaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public List<FruitTransaction> parser(List<String> inputData) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < inputData.size(); i++) {
            String[] data = inputData.get(i).split(",");
            transaction.setOperation(FruitTransaction.Operation.valueOf(data[0]));
            transaction.setFruit(data[1]);
            transaction.setQuantity(Integer.parseInt(data[2]));
            fruitTransactions.add(transaction);
        }
        return fruitTransactions;
    }
}
