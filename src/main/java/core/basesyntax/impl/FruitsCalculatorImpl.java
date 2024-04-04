package core.basesyntax.impl;

import core.basesyntax.database.DataBase;
import core.basesyntax.database.FruitTransaction;
import core.basesyntax.service.FruitsCalculator;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FruitsCalculatorImpl implements FruitsCalculator {
    private static final String SEPARATOR = ",";

    @Override
    public Map<String, Integer> applyQuantity(List<FruitTransaction> list) {
        Map<String, Integer> map = DataBase.mapDb;
        for (FruitTransaction value : list) {
            if (value.getOperation().equals(DataBase.Operation.BALANCE.getCode())) {
                map.put(value.getFruit(), value.getQuantity());
            }
            if (value.getOperation().equals(DataBase.Operation.BALANCE.getCode())) {
                map.put(value.getFruit(), value.getQuantity());
            }
            if (value.getOperation().equals("+")) {
                map.put(value.getFruit(), map.get(value.getFruit()) + value.getQuantity());
            }
            if (value.getOperation().equals("-")) {
                map.put(value.getFruit(), map.get(value.getFruit()) - value.getQuantity());
            }
        }
        return map;
    }

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> list = new ArrayList<>();
        for (String fruits : data) {
            String[] parts = fruits.split(SEPARATOR);
            String name = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            if (parts[0].equals(DataBase.Operation.BALANCE.getCode())) {
                list.add(new FruitTransaction(parts[0], name, quantity));
            }
            if (parts[0].equals(DataBase.Operation.PURCHASE.getCode())) {
                list.add(new FruitTransaction("-", name, quantity));
            }
            if (parts[0].equals(DataBase.Operation.RETURN.getCode())) {
                list.add(new FruitTransaction("+", name, quantity));
            }
            if (parts[0].equals(DataBase.Operation.SUPPLY.getCode())) {
                list.add(new FruitTransaction("+", name, quantity));
            }
        }
        System.out.println(list);
        return list;
    }
}
