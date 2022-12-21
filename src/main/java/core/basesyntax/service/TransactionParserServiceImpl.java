package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class TransactionParserServiceImpl implements TransactionParserService {
    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();

        for (String line : list) {
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
        throw new RuntimeException(value + " - operation is not exist in enum");
    }
}
