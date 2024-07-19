package core.basesyntax.service;

import core.basesyntax.domain.Fruit;
import java.util.List;
import java.util.stream.Collectors;

public class DataConverterImpl implements DataConverterService {
    private static final String COMMA_DELIMITER = ",";
    private static final int COUNT_HEADER_LINES_TO_SKIP = 1;
    private static final int FRUIT_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;

    @Override
    public List<Fruit> convertToFruit(List<String> inputReport) {
        return inputReport.stream()
                .skip(COUNT_HEADER_LINES_TO_SKIP)
                .map(line -> line.split(COMMA_DELIMITER))
                .map(line -> new Fruit(
                        Fruit.Operation.getByCode(line[FRUIT_OPERATION_INDEX]),
                        line[FRUIT_NAME_INDEX],
                        Integer.parseInt(line[FRUIT_QUANTITY_INDEX])
                ))
                .collect(Collectors.toList());
    }
}
