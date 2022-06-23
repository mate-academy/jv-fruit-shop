package core.basesyntax.service.mapper;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class FruitTransactionMapper {
    private static final String SEPARATOR = ",";
    private static final int LETTER_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

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
