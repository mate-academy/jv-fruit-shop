package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Operation;

public class GenerateReport {
    private final Map<String, Integer> fruitStock;

    public GenerateReport() {
        fruitStock = new HashMap<>();
    }

    public void calculateFruitsStock(List<String> fruitData) {
        for (String entry : fruitData) {
            String[] data = entry.split(",");
            String operationCode = data[0];
            String fruit = data[1];
            int quantity = Integer.parseInt(data[2]);

            fruitStock.putIfAbsent(fruit, 0);

            int stock = fruitStock.get(fruit);
            if (operationCode.equals(Operation.BALANCE.getCode())
                    || operationCode.equals(Operation.SUPPLY.getCode())
                    || operationCode.equals(Operation.RETURN.getCode())) {
                stock += quantity;
            } else if (operationCode.equals(Operation.PURCHASE.getCode())) {
                stock -= quantity;
            }
            fruitStock.put(fruit, stock);
        }
    }

    public Map<String, Integer> getStock() {
        return fruitStock;
    }
}
