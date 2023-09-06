package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileDataConvertorService;
import java.util.List;
import java.util.stream.Collectors;

public class FileDataConvertorServiceImpl implements FileDataConvertorService {
    public static final String COMA = ",";
    public static final int OPERATION_INDEX = 0;
    public static final int FRUIT_NAME_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToFruitTransaction(List<String> fileLines) {
        return fileLines.stream()
                .map(e -> e.split(COMA))
                .map(e -> new FruitTransaction(e[OPERATION_INDEX],
                        e[FRUIT_NAME_INDEX],
                        Integer.parseInt(e[QUANTITY_INDEX].trim())))
                .collect(Collectors.toList());
    }
}
