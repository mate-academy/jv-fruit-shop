package core.basesyntax.service.transactionservice;

import core.basesyntax.model.dto.TransactionDto;
import core.basesyntax.model.operations.Operation;
import core.basesyntax.model.product.Fruit;
import java.util.ArrayList;
import java.util.List;

public class TransactionDtoServiceImpl implements TransactionDtoService {
    private static final String SPLITTER = ",";
    private static final String VALID_REGEX = "[bspr],[a-z]+,[0-9]+";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<TransactionDto> transform(List<String> data) {
        List<TransactionDto> transactionDataEntityList = new ArrayList<>();
        for (String line : data) {
            if (!checkLineIsValid(line)) {
                continue;
            }
            String[] values = line.split(SPLITTER);
            TransactionDto transactionDto = new TransactionDto(
                    Operation.getOperationByLetter(values[OPERATION_INDEX]),
                    new Fruit(values[FRUIT_INDEX]),
                    Integer.parseInt(values[AMOUNT_INDEX]));
            transactionDataEntityList.add(transactionDto);
        }
        return transactionDataEntityList;
    }

    private boolean checkLineIsValid(String line) {
        return line.matches(VALID_REGEX);
    }
}
