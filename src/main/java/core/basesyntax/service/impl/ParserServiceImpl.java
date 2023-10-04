package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMMA_SEPARATOR = ",";
    private static final int TYPE_POSITION = 0;
    private static final int FRUIT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> dataList) {
        return dataList.stream()
                .map(line -> line.split(COMMA_SEPARATOR))
                .map(array -> new FruitTransaction(
                        FruitTransaction.Operation.getByCode(array[TYPE_POSITION]),
                        array[FRUIT_POSITION],
                        Integer.parseInt(array[QUANTITY_POSITION])))
                .collect(Collectors.toList());
    }
}
