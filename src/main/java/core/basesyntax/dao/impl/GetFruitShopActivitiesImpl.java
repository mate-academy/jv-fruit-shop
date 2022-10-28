package core.basesyntax.dao.impl;

import core.basesyntax.dao.GetFruitShopActivities;

public class GetFruitShopActivitiesImpl implements GetFruitShopActivities {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String[] getActivities(String dataFromFile) {
        return dataFromFile.split(END_LINE);
    }
}
