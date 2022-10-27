package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.GetFruitShopActivities;

public class GetFruitShopActivitiesImpl implements GetFruitShopActivities {
    private static final String END_LINE = System.lineSeparator();

    @Override
    public String[] getActivities(String dataFromFile) {
        return dataFromFile.split(END_LINE);
    }
}
