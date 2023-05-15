package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitParserService;
import java.util.List;
import java.util.stream.Collectors;

public class FruitParserServiceImpl implements FruitParserService {
    private static final String SEPARATOR = ",";
    private static final int FIRST_LINE_DATA = 0;

    private static final int VALID_LENGTH_DATA = 1;
    private static final int OPERATION = FIRST_LINE_DATA;
    private static final int FRUIT = VALID_LENGTH_DATA;
    private static final int QUANTITY = 2;

    @Override
    public List<FruitTransaction> parserFruitTransaction(List<String> listInpFromFile) {
        if (listInpFromFile.size() > VALID_LENGTH_DATA) {
            listInpFromFile.remove(FIRST_LINE_DATA);
        }
        return listInpFromFile.stream()
                .map(s -> s.split(SEPARATOR))
                .map(s -> new FruitTransaction(
                        FruitTransaction.Operation.getOperationByCode(s[OPERATION]),
                        s[FRUIT],
                        Integer.parseInt(s[QUANTITY])))
                .collect(Collectors.toList());
    }
}
