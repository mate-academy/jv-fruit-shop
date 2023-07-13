package core.basesyntax.dao.impl;

import core.basesyntax.dao.ShopActivitiesParser;

public class ShopActivitiesParserImpl implements ShopActivitiesParser {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String[] parseActivities(String dataFromFile) {
        if (dataFromFile != null) {
            return dataFromFile.split(END_LINE);
        } else {
            throw new RuntimeException("Empty data!");
        }
    }
}
