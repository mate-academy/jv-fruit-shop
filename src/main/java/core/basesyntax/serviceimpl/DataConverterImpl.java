package core.basesyntax.serviceimpl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public Transaction convert(String lines) {
        if (lines.startsWith("type")) {
            return null;
        }
        String[] parts = lines.split(",");
        Operation operation = Operation.fromCode(parts[0]);
        String fruit = parts[1];
        Integer quantity = Integer.parseInt(parts[2]);
        return new Transaction(operation, fruit, quantity);
    }

    public List<Transaction> convert(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (String line : lines) {
            Transaction transaction = convert(line);
            if (transaction != null) {
                transactions.add(transaction);
            }
        }
        return transactions;
    }
}
