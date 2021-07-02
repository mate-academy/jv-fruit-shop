package core.basesyntax.service;

import core.basesyntax.model.OperationHandler;
import core.basesyntax.service.validator.Validator;
import java.util.List;

public class FruitReportServiceImpl implements ShopReportService {
    private static final String WORDS_SEPARATOR = ",";
    private final Validator validator;
    private final OperationHandler operationHandler;

    public FruitReportServiceImpl(Validator validator, OperationHandler operationHandler) {
        this.validator = validator;
        this.operationHandler = operationHandler;
    }

    @Override
    public String makeReport(List<String> inputData) {
        validator.validate(inputData);
        addDataToDB(inputData);
        return operationHandler.getCurrentStorageState();
    }

    private void addDataToDB(List<String> inputData) {
        for (String record : inputData) {
            String[] words = record.trim().split(WORDS_SEPARATOR);
            operationHandler.processRequest(words[0], words[1], Integer.parseInt(words[2]));
        }
    }
}
