package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ParserService;
import java.util.ArrayList;
import java.util.List;

public class ParserServiceImpl implements ParserService {
    private static final String SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<Transaction> parseLines(List<String> inputData) {
        List<Transaction> transactions = new ArrayList<>();
        inputData.remove(0);
        for (String line : inputData) {
            String[] parsedLines = line.split(SPLITTER);
            transactions.add(new Transaction(Operation.getOperation(parsedLines[OPERATION_INDEX]),
                    new Fruit(parsedLines[FRUIT_INDEX]),
                    Integer.parseInt(parsedLines[QUANTITY_INDEX])));
        }
        return transactions;
    }
}
