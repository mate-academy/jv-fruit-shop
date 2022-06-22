package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.InputDataMapper;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionMapper implements InputDataMapper<FruitTransaction> {
    private static final String SEPARATOR = ",";
    private static final int LETTER_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> map(List<String> linesData) {
        return linesData.stream()
                .skip(1)
                .map(s -> {
                    String[] lineData = s.split(SEPARATOR);
                    return new FruitTransaction(
                            lineData[LETTER_INDEX],
                            lineData[FRUIT_INDEX],
                            Integer.parseInt(lineData[QUANTITY_INDEX])); })
                .collect(Collectors.toList());
    }
}
