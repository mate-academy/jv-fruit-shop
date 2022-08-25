package core.basesyntax.parse;

import core.basesyntax.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class DataParserImpl implements DataParser {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITTER = ",";

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .map(s -> s.split(SPLITTER))
                .map(strings -> new FruitTransaction(
                        strings[OPERATION_INDEX],
                        strings[FRUIT_INDEX],
                        Integer.parseInt(strings[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
