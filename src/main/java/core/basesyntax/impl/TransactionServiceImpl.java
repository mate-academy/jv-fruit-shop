package core.basesyntax.impl;

import core.basesyntax.database.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionService;
import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {
    private static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> list = new ArrayList<>();
        for (String fruits : data) {
            String[] parts = fruits.split(SEPARATOR);
            String name = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            if (parts[0].equals(Operation.BALANCE.getCode())) {
                list.add(new FruitTransaction(Operation.BALANCE, name, quantity));
            }
            if (parts[0].equals(Operation.PURCHASE.getCode())) {
                list.add(new FruitTransaction(Operation.PURCHASE, name, quantity));
            }
            if (parts[0].equals(Operation.RETURN.getCode())) {
                list.add(new FruitTransaction(Operation.RETURN, name, quantity));
            }
            if (parts[0].equals(Operation.SUPPLY.getCode())) {
                list.add(new FruitTransaction(Operation.SUPPLY, name, quantity));
            }
        }
        System.out.println(list);
        return list;
    }
}
