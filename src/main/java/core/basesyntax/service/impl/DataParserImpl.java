package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import java.util.ArrayList;
import java.util.List;

public class DataParserImpl implements DataParser {
    private static final String DELIMITER = ",";
    private static final int HEADER_POS = 0;
    private static final int FROM_VALUE_POS = 1;
    private static final int TYPE_POS = 0;
    private static final int FRUIT_POS = 1;
    private static final int QUANTITY_POS = 2;
    private static final String[] HEADER = new String[] {"type", "fruit", "quantity"};
    private static final int PROPER_LINE_LENGTH = 3;


    /*
    Main method to parse all data from CSV.
     */
    @Override
    public List<FruitTransaction> parseTransactions(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        if (data.isEmpty()) {
            throw new RuntimeException("Empty data");
        }
        String[] header = splitData(data.get(HEADER_POS));
        if (!checkFormat(header) || checkLineLength(header)) {
            throw new RuntimeException("Incorrect CSV formatting");
        }
        for (int i = FROM_VALUE_POS; i < data.size(); i++) {
            String line = data.get(i);
            String[] splitData = splitData(line);
            if (checkLineLength(splitData)) {
                throw new RuntimeException("Incorrect line length");
            }
            transactions.add(toTransaction(splitData));
        }
        return transactions;
    }

    /*
    Pretty hard to read, but it's chek right columns in CSV by comparing with hardcoded String's.
    Not really necessary, but in case if some value will change throw Runtime
     */
    private boolean checkFormat(String[] dataLine) {
        return dataLine[TYPE_POS].equals(HEADER[TYPE_POS])
                && dataLine[FRUIT_POS].equals(HEADER[FRUIT_POS])
                && dataLine[QUANTITY_POS].equals(HEADER[QUANTITY_POS]);
    }

    /*
    Create instance of FruitTransaction and return it.
     */
    private FruitTransaction toTransaction(String[] dataLine) {
        FruitTransaction transaction = new FruitTransaction();

        transaction.setOperation(FruitTransaction.Operation.getByCode(dataLine[TYPE_POS]));
        transaction.setName(dataLine[FRUIT_POS]);
        transaction.setQuantity(Integer.parseInt(dataLine[QUANTITY_POS]));

        return transaction;
    }

    private boolean checkLineLength(String[] dataLine) {
        return dataLine.length != PROPER_LINE_LENGTH;
    }

    private String[] splitData(String line) {
        return line.split(DELIMITER);
    }
}
