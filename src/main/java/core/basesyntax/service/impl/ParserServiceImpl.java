package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseData(List<String> data) {
        return data.stream()
                .map(s -> s.split(","))
                .filter(s -> Character.isDigit(s[QUANTITY_INDEX].charAt(TYPE_INDEX)))
                .map(s -> new FruitTransaction(s[TYPE_INDEX],
                        s[FRUIT_INDEX],
                        Integer.parseInt(s[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
