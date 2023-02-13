package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class TransactionParserImpl implements TransactionParser {
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_AMOUNT = 2;
    private static final String SEPARATOR = ",";
    private static final String VALID_DATA = "[bprs],[a-z]*,[0-9]*";

    @Override
    public List<FruitTransaction> parseLine(List<String> data) {
        isValidData(data);
        List<FruitTransaction> resultList = new ArrayList<>();
        data.stream()
                .filter(e -> !e.equals("type,fruit,quantity"))
                .map(e -> e.split(SEPARATOR))
                .forEach(e -> resultList.add(new FruitTransaction(e[INDEX_OPERATION],
                        e[INDEX_FRUIT], Integer.parseInt(e[INDEX_AMOUNT]))));
        return resultList;
    }

    public void isValidData(List<String> inputData) {
        if (inputData.isEmpty()) {
            throw new RuntimeException("File is empty");
        }
        for (String str : inputData) {
            if (!Pattern.matches(VALID_DATA, str) && !str.equals("type,fruit,quantity")) {
                throw new RuntimeException("Invalid input data");
            }
        }
    }
}
