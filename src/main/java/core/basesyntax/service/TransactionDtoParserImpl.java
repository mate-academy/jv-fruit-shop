package core.basesyntax.service;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class TransactionDtoParserImpl implements TransactionDtoParser {
    private static final int TITLE_LINE = 0;
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final Validator validator = new ValidatorImpl();

    @Override
    public List<TransactionDto> parseData(List<String> dataFromFile) {
        validator.isDataValid(dataFromFile);
        validator.checkValidOfAmount(dataFromFile);
        dataFromFile.remove(TITLE_LINE);
        List<TransactionDto> parsedData = new ArrayList<>();
        for (String line : dataFromFile) {
            String[] rowFromFile = line.split(",");
            parsedData.add(new TransactionDto(rowFromFile[TYPE_OPERATION_INDEX],
                    new Fruit(rowFromFile[FRUIT_INDEX]),
                    Integer.parseInt(rowFromFile[AMOUNT_INDEX])));
        }
        return parsedData;
    }
}
