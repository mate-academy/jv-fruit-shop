package core.basesyntax.service.parser;

import core.basesyntax.exception.EntryFormatException;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Product;
import core.basesyntax.model.TransactionDto;
import java.util.ArrayList;
import java.util.List;

public class TransactionDtoParserImpl implements TransactionDtoParser {
    private static final String CSV_FORMAT = "[b,s,r,p],[a-z]+,[0-9]+";
    private static final String SKIP_LINE = "type,fruit,quantity";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";
    private static final String EXCEPTION_MESSAGE = "Entry format should be " + CSV_FORMAT;

    @Override
    public List<TransactionDto> parse(List<String> records) {
        List<TransactionDto> dtoList = new ArrayList<>();
        for (String record : records) {
            if (record.equals(SKIP_LINE)) {
                continue;
            }
            if (!record.matches(CSV_FORMAT)) {
                throw new EntryFormatException(EXCEPTION_MESSAGE
                        + " but was [" + record + "]");
            }
            String[] fields = record.split(SPLITERATOR);
            Operation operation = Operation.getOperationByLetter(fields[OPERATION_INDEX]);
            Product fruit = new Product(fields[FRUIT_INDEX]);
            int amount = Integer.parseInt(fields[QUANTITY_INDEX]);
            TransactionDto product = new TransactionDto(operation, fruit, amount);
            dtoList.add(product);
        }
        return dtoList;
    }
}
