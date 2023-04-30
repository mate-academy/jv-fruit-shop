package service.impl;

import static db.StorageTransaction.fruitTransactionList;

import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.Parser;

public class ParserImpl implements Parser {
    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        int operationIndex = 0;
        int fruitIndex = 1;
        int quantityIndex = 2;
        for (String line : dataFromFile) {
            String[] fields = line.split(",");
            Operation operation = Operation.getOperation(fields[operationIndex]);
            if (operation == null) {
                continue;
            }
            String fruit = fields[fruitIndex];
            int quantity = Integer.parseInt(fields[quantityIndex].trim());
            fruitTransactionList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactionList;
    }
}
