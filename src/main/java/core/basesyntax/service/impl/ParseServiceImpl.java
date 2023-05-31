package core.basesyntax.service.impl;

import core.basesyntax.model.FruitModel;
import core.basesyntax.service.ParseService;

import java.util.List;
import java.util.stream.Collectors;

public class ParseServiceImpl implements ParseService {
    private static final String COMA_SEPARATOR = ",";
    private static final int SKIP_LINE = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitModel> parsedData(List<String> dataFromFile) {
        return dataFromFile.stream().skip(SKIP_LINE)
                .map(this::dataFromString)
                .collect(Collectors.toList());
    }

    private FruitModel dataFromString(String string) {
    String[] split = string.split(COMA_SEPARATOR);
    return new FruitModel(FruitModel.getOperation(split[OPERATION_INDEX]),
            split[FRUIT_INDEX],
            Integer.parseInt(split[QUANTITY_INDEX]));
    }
}
