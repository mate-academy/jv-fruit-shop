package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvTransactionParser;
import java.util.ArrayList;
import java.util.List;

public class CsvTransactionParserImpl implements CsvTransactionParser {
    private static final int FIRST_SCV_VALUE_INDEX = 1;
    private static final String CSV_SPLITTER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;

    @Override
    public List<FruitTransaction> csvParse(List<String> fruitTransactionList) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = FIRST_SCV_VALUE_INDEX; i < fruitTransactionList.size(); i++) {
            String[] singleDataLine = fruitTransactionList.get(i).split(CSV_SPLITTER);
            fruitTransactions.add(
                    new FruitTransaction(
                            FruitTransaction.Operation
                                    .valueOfLabel(singleDataLine[OPERATION_INDEX]),
                            singleDataLine[PRODUCT_NAME_INDEX],
                            Integer.parseInt(singleDataLine[AMOUNT_INDEX])));
        }
        return fruitTransactions;
    }
}
