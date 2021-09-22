package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperationDto;
import java.util.function.Function;

public class FruitOperationDtoMapper implements Function<String, FruitOperationDto> {
    private static final int OPERATION_FRUIT_INDEX = 0;
    private static final int NAME_FRUIT_INDEX = 1;
    private static final int QUANTITY_FRUIT_INDEX = 2;
    private String[] data;

    @Override
    public FruitOperationDto apply(String value) {
        data = value.split(",");
        return new FruitOperationDto(FruitOperationDto
                .Type.valueOfLabel(data[OPERATION_FRUIT_INDEX]),
                data[NAME_FRUIT_INDEX],
                Integer.parseInt(data[QUANTITY_FRUIT_INDEX]));
    }
}
