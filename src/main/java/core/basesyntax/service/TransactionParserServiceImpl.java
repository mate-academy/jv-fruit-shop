package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    @Override
    public List<FruitTransaction> parse(List<String> list) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String transaction : list) {
            String[] transactionArr = transaction.split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            try {
                fruitTransaction.setOperation(parseOperation(transactionArr[0]));
            } catch (RuntimeException e) {
                System.out.println(e);
                continue;
            }
            fruitTransaction.setFruit(transactionArr[1]);
            fruitTransaction.setQuantity(Integer.parseInt(transactionArr[2]));
            fruitTransactionList.add(fruitTransaction);
        }
        return fruitTransactionList;
    }

    private FruitTransaction.Operation parseOperation(String value) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(value)) {
                return operation;
            }
        }
        throw new RuntimeException("Such Operation is not exist in enum");
    }
}
