package core.basesyntax.services;

import core.basesyntax.model.Operation;
import java.util.ArrayList;
import java.util.List;

public class FormattedDataImpl implements FormattedData {
    private static final int TITLE_INDEX = 0;
    private static final String COMMA = ",";
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int QUANTITY_INDEX = 2;
    private static final int FRUIT_NAME_INDEX = 1;
    private final ValidatorService validatorService = new ValidatorServiceImpl();
    private List<Operation> formattedData;

    @Override
    public List<Operation> formattedData(List<String> dataFromFile) {
        validatorService.inputDataValidator(dataFromFile);
        validatorService.positiveQuantityValidator(dataFromFile);
        dataFromFile.remove(TITLE_INDEX);
        String[] lineFromFile;
        List<Operation> formattedData = new ArrayList<>();
        for (String line : dataFromFile) {
            lineFromFile = line.split(COMMA);
            formattedData.add(new Operation(lineFromFile[TYPE_OPERATION_INDEX],
                    lineFromFile[FRUIT_NAME_INDEX],
                    Integer.parseInt(lineFromFile[QUANTITY_INDEX])));
        }
        return formattedData;
    }
}

