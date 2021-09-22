package core.basesyntax.service.parser;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import java.util.ArrayList;
import java.util.List;

public class OperationParserImpl implements OperationParser {
    private static final int INPUT_FILE_HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final Validator validator;

    public OperationParserImpl() {
        this.validator = new ValidatorImpl();
    }

    @Override
    public List<TransactionDto> parseOperations(List<String> inputData) {
        List<TransactionDto> operationsList = new ArrayList<>();
        inputData.remove(INPUT_FILE_HEADER_INDEX);
        for (String data : inputData) {
            String[] split = data.split(",");
            if (validator.isValidData(split)) {
                operationsList.add(
                        new TransactionDto(OperationType.getOperation(split[OPERATION_INDEX]),
                        new Fruit(split[FRUIT_INDEX]),
                        Integer.parseInt(split[AMOUNT_INDEX])));
            }
        }
        return operationsList;
    }
}
