package core.basesyntax.dao.impl;

import core.basesyntax.dao.ShopParser;

public class ShopParserImpl implements ShopParser {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String[] parse(String dateFromFile) {
        if (dateFromFile != null) {
            return dateFromFile.split(END_LINE);
        } else {
            throw new RuntimeException("Empty date");
        }
    }
}
