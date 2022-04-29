package core.basesyntax.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.servise.ParseDataService;
import java.util.ArrayList;
import java.util.List;

public class ParseDataServiceImpl implements ParseDataService {
    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 0; i < dataFromFile.size(); i++) {
            String line = dataFromFile.get(i);
            String [] records = line.split(",");
            transactions.add(new FruitTransaction(getOperation(records[0]),
                    new Fruit(records[1]), Integer.parseInt(records[2])));
        }
        return transactions;
    }

    private FruitTransaction.Operation getOperation(String option) {
        switch (option) {
            case "b":
                return FruitTransaction.Operation.BALANCE;
            case "p":
                return FruitTransaction.Operation.PURCHASE;
            case "s":
                return FruitTransaction.Operation.SUPPLY;
            case "r":
                return FruitTransaction.Operation.RETURN;
            default:
                throw new RuntimeException("Unknown operation " + option);
        }
    }
}
