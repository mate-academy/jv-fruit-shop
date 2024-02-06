package core.basesyntax.converter;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import java.util.ArrayList;
import java.util.List;

public class StringTransactionConverterImpl implements StringTransactionConverter {
    private static final String COMA = ",";

    @Override
    public List<Transaction> convert(List<String> stringTransactions) {
        List<Transaction> transactions = new ArrayList<>();
        String[] fields;

        for (int i = 1; i < stringTransactions.size(); i++) {
            Transaction transaction = new Transaction();
            Fruit fruit = new Fruit();
            fields = stringTransactions.get(i).split(COMA);

            transaction.setTransactionType(Transaction.TransactionType
                    .getTransactionTypeByCode(fields[0]));
            fruit.setFruitName(fields[1]);
            transaction.setFruit(fruit);
            transaction.setAmount(Integer.parseInt(fields[2]));

            transactions.add(transaction);
        }
        return transactions;
    }
}
