package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
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
            if (parts[0].equals(DataBase.Operation.BALANCE.getCode())) {
                list.add(new FruitTransaction(DataBase.Operation.BALANCE, name, quantity));
            }
            if (parts[0].equals(DataBase.Operation.PURCHASE.getCode())) {
                list.add(new FruitTransaction(DataBase.Operation.PURCHASE, name, quantity));
            }
            if (parts[0].equals(DataBase.Operation.RETURN.getCode())) {
                list.add(new FruitTransaction(DataBase.Operation.RETURN, name, quantity));
            }
            if (parts[0].equals(DataBase.Operation.SUPPLY.getCode())) {
                list.add(new FruitTransaction(DataBase.Operation.SUPPLY, name, quantity));
            }
        }
        System.out.println(list);
        return list;
    }
}
