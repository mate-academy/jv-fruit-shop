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
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(getOperation(line));
            fruitTransaction.setFruit(getFruit(line));
            fruitTransaction.setQuantity(getAmount(line));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }

    private FruitTransaction.Operation getOperation(String lineFromData) {
        String[] split = lineFromData.split(",");
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(split[0])) {
                return operation;
            }
        }
        return null;
    }

    private Fruit getFruit(String lineFromData) {
        String[] split = lineFromData.split(",");
        return new Fruit(split[1]);
    }

    private Integer getAmount(String lineFromData) {
        String[] split = lineFromData.split(",");
        return Integer.valueOf(split[2]);
    }
}
