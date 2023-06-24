package service.impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import model.Operation;
import service.FruitTransactionParser;

public class FruitTransactionParserImpl implements FruitTransactionParser {
    private static final int TITLE_LINE_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLIT_COMMA = ",";

    @Override
    public List<FruitTransaction> parseList(List<String> data) {
        data.remove(TITLE_LINE_INDEX);
        return data.stream()
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }

    private FruitTransaction getFruitTransaction(String data) {
        String[] info = data.split(SPLIT_COMMA);
        return new FruitTransaction(Operation.parseOperation(info[OPERATION_INDEX]),
                info[FRUIT_INDEX], Integer.parseInt(info[QUANTITY_INDEX]));
    }
}
