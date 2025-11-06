package core.basesyntax.service.impl;

import core.basesyntax.DataParser;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParserService;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private final DataParser dataParser;

    public DataParserServiceImpl(DataParser dataParser) {
        this.dataParser = dataParser;
    }

    public List<FruitTransaction> parse(List<String> data) {
        return this.dataParser.parse(data);
    }
}
