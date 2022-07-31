package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParseService;
import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int NAME_FRUIT_INDEX = 1;
    private static final int QUANTITY_FRUIT_INDEX = 2;

    @Override
    public List<FruitTransaction> getListArrayParse(List<String> lines) {
        return lines.stream()
                .skip(1)
                .map(s -> s.split(","))
                .map(s -> new FruitTransaction(FruitTransaction.Operation
                        .getTypeOperation(s[TYPE_OPERATION_INDEX]),
                        s[NAME_FRUIT_INDEX],Integer.parseInt(s[QUANTITY_FRUIT_INDEX])))
                .collect(Collectors.toList());
    }
}
