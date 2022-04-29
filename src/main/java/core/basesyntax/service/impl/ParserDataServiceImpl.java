package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserDataService;
import java.util.ArrayList;
import java.util.List;

public class ParserDataServiceImpl implements ParserDataService {
    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            transactions.add(getTransaction(line));
        }
        return transactions;
    }

    private FruitTransaction getTransaction(String lineFromData) {
        String[] split = lineFromData.split(",");
        FruitTransaction transaction = new FruitTransaction();
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(split[0])) {
                transaction.setOperation(operation);
            }
        }
        transaction.setFruit(new Fruit(split[1]));
        transaction.setQuantity(Integer.parseInt(split[2]));
        return transaction;

    }
}
