package core.basesyntax.dao.impl;

import core.basesyntax.dao.GetFruitShopActivities;

public class GetFruitShopActivitiesImpl implements GetFruitShopActivities {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String[] getActivities(String dataFromFile) {
        if (dataFromFile != null) {
            return dataFromFile.split(END_LINE);
        } else {
            throw new RuntimeException("Empty data!");
        }
    }
}
