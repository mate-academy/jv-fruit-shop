package core.basesyntax.service.impl;

import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.DataConverterService;
import java.util.ArrayList;
import java.util.List;

public class DataConverterServiceImpl implements DataConverterService {
    private static final String COMA_SEPARATOR = ",";
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_VALUE_INDEX = 2;
    private static final int HEAD_INDEX = 0;

    @Override
    public List<FruitDto> convertToDto(List<String> linesFromFile) {
        List<FruitDto> transactionsList = new ArrayList<>();
        linesFromFile.remove(HEAD_INDEX);
        for (String line : linesFromFile) {
            String[] strLineArray = line.split(COMA_SEPARATOR);
            FruitDto transaction = new FruitDto(strLineArray[TYPE_OPERATION_INDEX],
                    strLineArray[FRUIT_NAME_INDEX],
                    Integer.parseInt(strLineArray[FRUIT_VALUE_INDEX]));
            transactionsList.add(transaction);
        }
        return transactionsList;
    }
}
