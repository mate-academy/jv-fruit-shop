package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final String COMA = ",";
    private static final int FIRST_POSITION = 0;
    private static final int SECOND_POSITION = 1;
    private static final int THIRD_POSITION = 2;

    @Override
    public List<FruitTransaction> formatData(List<String> dataList) {
        return dataList.stream()
                .map(line -> line.split(COMA))
                .map(array -> new FruitTransaction(
                        FruitTransaction.Operation.getByCode(array[FIRST_POSITION]),
                        array[SECOND_POSITION],
                        Integer.parseInt(array[THIRD_POSITION])))
                .collect(Collectors.toList());
    }
}
