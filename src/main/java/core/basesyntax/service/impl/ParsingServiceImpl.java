package core.basesyntax.service.impl;

import core.basesyntax.service.ParsingService;

public class ParsingServiceImpl implements ParsingService {
    private static final String DELIMITER = ",";

    @Override
    public String[] parseTransactionLine(String line) {
        return line.split(DELIMITER);
    }
}
