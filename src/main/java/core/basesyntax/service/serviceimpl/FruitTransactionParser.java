package core.basesyntax.service.serviceimpl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.DataFileCorruptedException;
import core.basesyntax.model.Operation;
import core.basesyntax.service.interfaces.TransactionParser;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class FruitTransactionParser implements TransactionParser<FruitTransactionDto> {
    private static final int OPERATION_NEXT_INDEX = 0;
    private static final int MIN_COLUMNS_NUMBER = 3;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FIRST_CSV_LINE = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final String DIVIDER = ",";

    @Override
    public List<FruitTransactionDto> parse(List<String> rawStrings) {
        if (rawStrings == null || rawStrings.isEmpty()) {
            throw new DataFileCorruptedException("No data found in file");
        }
        var transactions = new ArrayList<FruitTransactionDto>(rawStrings.size() - FIRST_CSV_LINE);
        for (int i = FIRST_CSV_LINE; i < rawStrings.size(); i++) {
            String line = rawStrings.get(i);
            String[] columns = line.split(DIVIDER);
            validateRawData(columns);
            String operationCode = columns[OPERATION_NEXT_INDEX].trim();
            Operation operation = Operation.findByCode(operationCode);
            String fruitName = columns[FRUIT_NAME_INDEX].trim();
            int fruitQuantity = Integer.parseInt(columns[FRUIT_QUANTITY_INDEX].trim());
            var dto = new FruitTransactionDto(operation, fruitName, fruitQuantity);
            transactions.add(dto);
        }
        return transactions;
    }

    private void validateRawData(String[] columns) {
        if (columns.length < MIN_COLUMNS_NUMBER) {
            throw new DataFileCorruptedException("Invalid number of columns in data");
        }
        for (String column : columns) {
            if (StringUtils.isBlank(column)) {
                throw new DataFileCorruptedException("Data in column is absent");
            }
        }
    }
}
