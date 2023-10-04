package core.basesyntax.service.filereader;

import core.basesyntax.model.FruitTransaction;
import java.util.ArrayList;
import java.util.List;

public class FileParserImpl implements FileParser {
    static final int OPERATION_TYPE_INDEX = 0;
    static final int FRUIT_TYPE_INDEX = 1;
    static final int FRUITS_QUANTITY_INDEX = 2;
    static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parsedFruitTransactions(List<String> fruitsTransactions) {
        List<FruitTransaction> parsedData = new ArrayList<>();
        for (String transaction : fruitsTransactions) {
            FruitTransaction fruitTransaction = new FruitTransaction();
            String[] splitTransaction = transaction.split(SEPARATOR);
            fruitTransaction.setOperation(new TransactionTypeFinderImpl()
                    .operationType(splitTransaction[OPERATION_TYPE_INDEX]));
            fruitTransaction.setFruit(splitTransaction[FRUIT_TYPE_INDEX]);
            fruitTransaction.setQuantity(Integer.parseInt(splitTransaction[FRUITS_QUANTITY_INDEX]));
            parsedData.add(fruitTransaction);
        }
        return parsedData;
    }
}
