package service.impl;

import static db.StorageTransaction.fruitTransactionList;

import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.Parser;

public class ParserImpl implements Parser {
    @Override
    public List<FruitTransaction> parse(List<String> dataFromFile) {
        for (String line : dataFromFile) {
            String[] fields = line.split(",");
            Operation operation = Operation.getOperation(fields[0]);
            if (operation == null) {
                continue;
            }
            String fruit = fields[1];
            int quantity = Integer.parseInt(fields[2].trim());
            fruitTransactionList.add(new FruitTransaction(operation, fruit, quantity));
        }
        return fruitTransactionList;
    }
}
