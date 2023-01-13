package core.basesyntax.serviceimpl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final int OPERATION_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private static final String SEPARATOR = ",";

    @Override
    public List<Transaction> parse(List<String> data) {
        List<Transaction> transactions = new ArrayList<>();
        Transaction transaction = new Transaction();
        data.stream()
                .forEach(d -> {
                    String[] column = d.split(SEPARATOR);
                    transaction.setSum(Integer.parseInt(column[QUANTITY_COLUMN]));
                    transaction.setFruit(column[FRUIT_COLUMN]);
                    transaction.setOperation(Arrays.stream(Operation.values())
                            .filter(o -> o.getOperation().equals(column[OPERATION_COLUMN]))
                            .findFirst()
                            .get());
                    transactions.add(transaction); }
                );
        return transactions;
    }
}
