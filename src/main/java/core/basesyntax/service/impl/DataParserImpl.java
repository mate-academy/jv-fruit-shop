package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String CSV_SPLITTER = ",";
    private static final int HEADER_ROW_INDEX = 0;
    private static final int TYPE_COLUMN_INDEX = 0;
    private static final int FRUIT_COLUMN_INDEX = 1;
    private static final int QUANTITY_COLUMN_INDEX = 2;

    public List<FruitTransaction> parseData(List<String> data) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        data.remove(HEADER_ROW_INDEX);
        for (String row : data) {
            String[] columns = row.split(CSV_SPLITTER);
            fruitTransactions.add(new FruitTransaction(
                    FruitTransaction.Operation.getOperationById(columns[TYPE_COLUMN_INDEX]),
                    columns[FRUIT_COLUMN_INDEX],
                    Integer.parseInt(columns[QUANTITY_COLUMN_INDEX])
            ));
        }
        return fruitTransactions;
    }
}
