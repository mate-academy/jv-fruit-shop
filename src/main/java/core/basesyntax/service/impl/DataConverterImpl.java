package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private final Parser parser = new Parser();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        return parser.parse(inputReport);
    }
}