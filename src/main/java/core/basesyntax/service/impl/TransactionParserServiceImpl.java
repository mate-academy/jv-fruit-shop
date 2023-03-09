package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParserService;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserServiceImpl implements TransactionParserService {
    private static final int INDEX_FIRST_LINE = 0;
    private static final int CODE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final String COMA = ",";

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        data.remove(INDEX_FIRST_LINE);
        return data.stream()
                .map(i -> i.split(COMA))
                .map(i -> new FruitTransaction(getOperation(i[CODE_INDEX]),
                        i[FRUIT_INDEX], Integer.parseInt(i[AMOUNT_INDEX])))
                .collect(Collectors.toList());
    }

    private FruitTransaction.Operation getOperation(String code) {
        return Arrays.stream(FruitTransaction.Operation.values())
                .filter(i -> i.getCode().equals(code))
                .findFirst().get();
    }
}
