package core.basesyntax.service.parse;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int HEAD_STRING_INDEX = 0;
    private static final String COMA = ",";

    @Override
    public List<FruitTransaction> parse(List<String> list) {
        list.remove(HEAD_STRING_INDEX);
        return list.stream()
                .map(this::createTransactionFromLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction createTransactionFromLine(String line) {
        String[] temp = line.split(COMA);
        return new FruitTransaction(temp[OPERATION_INDEX],
                temp[FRUIT_INDEX],
                Integer.parseInt(temp[QUANTITY_INDEX]));
    }
}
