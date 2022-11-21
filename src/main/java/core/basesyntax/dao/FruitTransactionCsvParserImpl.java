package core.basesyntax.dao;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.FileReader;
import core.basesyntax.services.FileReaderImpl;
import java.util.ArrayList;
import java.util.List;

public class FruitTransactionCsvParserImpl implements FruitTransactionCsvParser {
    private static final int OPERATION = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private static final String VALUES_SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parse(String fileName) {
        FileReader readerFromCsvFile = new FileReaderImpl();
        List<String> lines = readerFromCsvFile.readFromFile(fileName);
        ArrayList<FruitTransaction> fruitTransactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] split = lines.get(i).split(VALUES_SEPARATOR);
            fruitTransactions
                    .add(new FruitTransaction(FruitTransaction
                            .Operation.getOperationByCode(split[OPERATION]),
                            split[FRUIT],
                            Integer.parseInt(split[QUANTITY])));
        }
        return fruitTransactions;
    }
}
