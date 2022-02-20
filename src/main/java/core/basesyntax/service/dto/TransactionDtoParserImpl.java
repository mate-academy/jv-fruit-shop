package core.basesyntax.service.dto;

import core.basesyntax.exeptions.InvalidDataFormatException;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import java.util.ArrayList;
import java.util.List;

public class TransactionDtoParserImpl implements TransactionDtoParser {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String SKIP_LINE = "type,fruit,quantity";
    private static final String VALID_FORMAT = "[b,s,r,p],[a-z]+,[0-9]+";

    @Override
    public List<TransactionDto> parse(List<String> transactions) {
        List<TransactionDto> transactionsList = new ArrayList<>();
        for (String transaction : transactions) {
            if (transaction.equals(SKIP_LINE)) {
                continue;
            }
            if (!transaction.matches(VALID_FORMAT)) {
                throw new InvalidDataFormatException("Data format should be "
                        + VALID_FORMAT + ", but was [" + transaction + "]");
            }
            String[] fields = transaction.split(SEPARATOR);
            OperationType operation
                    = OperationType.getOperationType(fields[INDEX_OF_OPERATION_TYPE]);
            Fruit fruit = new Fruit(fields[INDEX_OF_FRUIT_TYPE]);
            int quantity = Integer.parseInt(fields[INDEX_OF_QUANTITY]);
            TransactionDto transactionDto = new TransactionDto(operation, fruit, quantity);
            transactionsList.add(transactionDto);
        }
        return transactionsList;
    }
}
