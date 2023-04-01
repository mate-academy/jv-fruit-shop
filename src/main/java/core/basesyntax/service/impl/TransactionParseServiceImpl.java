package core.basesyntax.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import core.basesyntax.enums.Operation;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParseService;

public class TransactionParseServiceImpl implements TransactionParseService {
    private static final String BRACKETS_REGEX = "\\[|\\]";
    private static final String COMA_REGEX = ",";
    private static final String SPACE_REGEX = " ";
    private static final int START_INDEX = 3;

    @Override
    public List<FruitTransaction> parseList(String data) {
        List<FruitTransaction> fruitTransactionList = new ArrayList<>();
        String newLineString = Arrays.toString(data.split(System.lineSeparator()));
        newLineString = newLineString.replaceAll(BRACKETS_REGEX, "");

        String[] comaSplitArray = newLineString.split(COMA_REGEX);

        for (int i = START_INDEX; i < comaSplitArray.length; i += 3) {
            comaSplitArray[i] = comaSplitArray[i].replaceAll(SPACE_REGEX, "");
            fruitTransactionList.add(new FruitTransaction(Operation.fromString(comaSplitArray[i]),
                    comaSplitArray[i + 1],
                    Integer.parseInt(comaSplitArray[i + 2])));
        }
        return fruitTransactionList;
    }
}
