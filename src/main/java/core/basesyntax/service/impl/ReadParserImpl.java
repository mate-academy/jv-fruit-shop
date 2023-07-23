package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadParserImpl implements core.basesyntax.service.ReadParser {
    private static final int INFO_LINE_INDEX = 0;
    private static final int OPERATION_TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int NUMBERS_INDEX = 2;
    private static final String COMMA = ",";
    private final Map<String, Operation> operations = new HashMap<>();

    {
        operations.put("b", Operation.BALANCE);
        operations.put("p", Operation.PURCHASE);
        operations.put("s", Operation.SUPPLY);
        operations.put("r", Operation.RETURN);
    }

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        lines.remove(INFO_LINE_INDEX);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] data = line.split(COMMA);
            transactions.add(new FruitTransaction(
                    operations.get(data[OPERATION_TYPE_INDEX]),
                    data[FRUIT_INDEX], Integer.parseInt(data[NUMBERS_INDEX])));
        }
        return transactions;
    }
}
