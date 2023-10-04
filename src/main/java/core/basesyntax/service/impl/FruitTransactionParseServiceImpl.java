package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionParseService;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParseServiceImpl implements FruitTransactionParseService {
    @Override
    public List<FruitTransaction> parseFruitTransaction(List<String> records) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < records.size(); i++) {
            String[] fields = records.get(i).split(",");
            FruitTransaction fruitTransaction = new FruitTransaction();
            fruitTransaction.setOperation(FruitTransaction.Operation
                    .getByCode(FruitTransaction.Operation.class, fields[0]));
            fruitTransaction.setFruit(fields[1]);
            fruitTransaction.setQuantity(Integer.parseInt(fields[2]));
            transactions.add(fruitTransaction);
        }
        return transactions;
    }
}
