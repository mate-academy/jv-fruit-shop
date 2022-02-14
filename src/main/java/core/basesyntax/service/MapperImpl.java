package core.basesyntax.service;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.inter.Mapper;

public class MapperImpl implements Mapper<String, FruitOperation> {
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String SEPARATOR = ",";

    @Override
    public FruitOperation map(String value) {
        String[] data = value.split(SEPARATOR);
        return new FruitOperation(data[TYPE], data[FRUIT], Integer.parseInt(data[QUANTITY]));
    }
}
