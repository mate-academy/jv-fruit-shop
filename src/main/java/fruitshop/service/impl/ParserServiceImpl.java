package fruitshop.service.impl;

import fruitshop.model.FruitTransaction;
import fruitshop.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {

    @Override
    public List<FruitTransaction> parse(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) { // Skip header
            String[] parts = data.get(i).split(",");
            FruitTransaction.Operation operation = mapOperation(parts[0]);
            String fruit = parts[1];
            int quantity = Integer.parseInt(parts[2]);
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }

    private FruitTransaction.Operation mapOperation(String code) {
        return switch (code) {
            case "b" -> FruitTransaction.Operation.BALANCE;
            case "s" -> FruitTransaction.Operation.SUPPLY;
            case "p" -> FruitTransaction.Operation.PURCHASE;
            case "r" -> FruitTransaction.Operation.RETURN;
            default -> throw new IllegalArgumentException("Unknown operation code: " + code);
        };
    }
}
