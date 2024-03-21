package core.basesyntax.service.serviceimpl;

import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.exception.DataFileCorrupted;
import core.basesyntax.service.interfaces.TransactionParser;
import core.basesyntax.service.interfaces.FruitStringsCheck;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser implements TransactionParser<FruitTransactionDto> {
    private static final int OPERATION_NEXT_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FIRST_CSV_LINE = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final String DIVIDER = ",";

    private final FruitStringsCheck checkFruitsInFile = new FruitStringsCheckImpl();

    @Override
    public List<FruitTransactionDto> parse(List<String> rawStrings) {
        if (!checkFruitsInFile.checkFruitQuantity(rawStrings)) {
            throw new DataFileCorrupted("Some data in file is missing");
        }
        var transactions = new ArrayList<FruitTransactionDto>(rawStrings.size() - FIRST_CSV_LINE);
        for (int i = FIRST_CSV_LINE; i < rawStrings.size(); i++) {
            String line = rawStrings.get(i);
            String[] columns = line.split(DIVIDER);
            try {
                int fruitQuantity = Integer.parseInt(columns[FRUIT_QUANTITY_INDEX].trim());
                var dto = new FruitTransactionDto(columns[OPERATION_NEXT_INDEX].trim(),
                        columns[FRUIT_NAME_INDEX].trim(),
                        fruitQuantity);
                transactions.add(dto);
            } catch (IllegalArgumentException e) {
                throw new DataFileCorrupted("Please check the quantity of the fruit"
                        + "it should be number(integer)"
                        + e.getMessage());
            }
        }
        return transactions ;
    }
}
