package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {

    @Override
    public List<FruitTransaction> parseTransactions(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            fruitTransactionList.add(getFromCvsRow(lines.get(i)));
        }
        return fruitTransactionList;
    }

    private FruitTransaction getFromCvsRow(String line) {
        String[] fields = line.split(",");
        FruitTransaction fruitTransaction = new FruitTransaction();
        String operationCode = fields[0].trim();
        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(operationCode);

        fruitTransaction.setOperation(operation);
        fruitTransaction.setFruit(fields[1]);
        fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
        return fruitTransaction;
    }
}
