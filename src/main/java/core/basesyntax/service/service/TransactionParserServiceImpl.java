package core.basesyntax.service.service;

import core.basesyntax.service.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserServiceImpl implements TransactionParserService {
    public static final int INDEX_OPTION = 0;
    public static final int INDEX_FRUIT_NAME = 1;
    public static final int INDEX_VALUE = 2;
    public static final int INDEX_REMAIN_LINE = 0;

    @Override
    public List<FruitTransaction> create(List<String[]> list) {
        list.remove(INDEX_REMAIN_LINE);
        return list.stream()
                .map(e -> new FruitTransaction(e[INDEX_OPTION],
                        e[INDEX_FRUIT_NAME],
                        Integer.parseInt(e[INDEX_VALUE])))
                .collect(Collectors.toList());
    }
}
