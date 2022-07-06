package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionConvertor;
import java.util.ArrayList;
import java.util.List;

public class TransactionConvertorImpl implements TransactionConvertor {
    @Override
    public List<FruitTransaction> getFruitTransactions(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(",");
            transactions.add(new FruitTransaction(split[0], split[1], Integer.parseInt(split[2])));
        }
        return transactions;
    }
}
