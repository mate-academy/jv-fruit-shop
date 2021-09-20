package core.basesyntax.dataservice;

import core.basesyntax.dao.InputDataReader;
import core.basesyntax.dao.InputDataReaderImpl;
import core.basesyntax.model.FruitType;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class OperationParserImpl implements OperationParser {
    private static final int INPUT_FILE_HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private final InputDataReader inputDataReader;
    private final Validator validator;

    public OperationParserImpl() {
        this.inputDataReader = new InputDataReaderImpl();
        this.validator = new Validator();
    }

    @Override
    public List<TransactionDto> parseOperations(String filePathFrom) {
        List<TransactionDto> operationsList = new ArrayList<>();
        List<String> inputData = inputDataReader.getDataFromFile(filePathFrom);
        inputData.remove(INPUT_FILE_HEADER_INDEX);
        for (String data : inputData) {
            String[] split = data.split(",");
            if (validator.isValidData(split)) {
                operationsList.add(new TransactionDto(OperationType.valueOf(split[OPERATION_INDEX]),
                        FruitType.valueOf(split[FRUIT_INDEX]),
                        Integer.parseInt(split[AMOUNT_INDEX])));
            }
        }
        return operationsList;
    }
}
