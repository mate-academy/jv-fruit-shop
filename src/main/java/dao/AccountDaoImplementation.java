package dao;

import db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.OperationService;
import service.impl.OperationStrategyImplementation;

public class AccountDaoImplementation implements AccountDao {

    @Override
    public void add(String fruit, Integer quantity) {
        Integer newAmount = Storage.fruits.containsKey(fruit)
                ? Storage.fruits.get(fruit) + quantity : quantity;
        Storage.fruits.put(fruit, newAmount);
    }

    @Override
    public void set(String fruit, Integer quantity) {
        Storage.fruits.put(fruit, quantity);
    }

    @Override
    public void subtract(String fruit, Integer quantity) {
        Integer newAmount = Storage.fruits.containsKey(fruit)
                ? Storage.fruits.get(fruit) - quantity : quantity;
        Storage.fruits.put(fruit, newAmount);
    }

    @Override
    public List<String[]> getBalance() {
        List<String[]> list = new ArrayList<>();
        for (Map.Entry<String, Integer> map : Storage.fruits.entrySet()) {
            String[] rowTable = new String[2];
            rowTable[0] = map.getKey();
            rowTable[1] = String.valueOf(map.getValue());
            list.add(rowTable);
        }
        return list;
    }

    @Override
    public void fill(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationService operationService = new OperationStrategyImplementation(this)
                    .getOperationServiceByTransaction(transaction);
            operationService.doTransaction(transaction);
        }
    }
}
