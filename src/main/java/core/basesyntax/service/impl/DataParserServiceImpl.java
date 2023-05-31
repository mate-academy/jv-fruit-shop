package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserServiceImpl implements DataParserService {
    private static final int INFORMATION_LINES_COUNT = 1;
    private static final String COMMA_SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> lines) {
        return lines.stream()
                .skip(INFORMATION_LINES_COUNT)
                .map(line -> line.split(COMMA_SEPARATOR))
                .map(data -> new FruitTransaction(
                        FruitTransaction.Operation.getByCode(data[TYPE_INDEX]),
                        data[FRUIT_INDEX],
                        Integer.parseInt(data[QUANTITY_INDEX])
                ))
                .collect(Collectors.toList());
    }
}
