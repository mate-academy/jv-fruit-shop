package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.Parser;

public class ParserImpl implements Parser {
    private static final int LINE_WITH_HEADER = 0;
    private static final int COLUMN_WITH_OPERATION_CODE = 0;
    private static final int COLUMN_WITH_FRUIT = 1;
    private static final int COLUMN_WITH_QUANTITY = 2;
    private static final int TOTAL_COLUMNS = 3;
    private static final String EXPECTED_REPORT_HEADER = "type,fruit,quantity";
    private static final String COLUMN_SEPARATOR = ",";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    @Override
    public List<FruitTransaction> getTransactions(String transactionsData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] linesArray = transactionsData.split(LINE_SEPARATOR);

        if (linesArray.length == 0) {
            return transactions;
        }

        if (linesArray[LINE_WITH_HEADER] == null
                || !linesArray[LINE_WITH_HEADER].equals(EXPECTED_REPORT_HEADER)) {
            throw new RuntimeException("Can't parse data."
                    + " Unexpected report header: " + linesArray[LINE_WITH_HEADER]);
        }

        for (int i = LINE_WITH_HEADER + 1; i < linesArray.length; i++) {
            String line = linesArray[i];
            String[] lineData = line.split(COLUMN_SEPARATOR);
            if (lineData.length != TOTAL_COLUMNS) {
                throw new RuntimeException("Can't parse transaction from line: " + line);
            }
            String operationCode = lineData[COLUMN_WITH_OPERATION_CODE];
            String fruit = lineData[COLUMN_WITH_FRUIT];
            int quantity = Integer.parseInt(lineData[COLUMN_WITH_QUANTITY]);
            try {
                FruitTransaction transaction = new FruitTransaction(operationCode, fruit, quantity);
                transactions.add(transaction);
            } catch (Exception e) {
                throw new RuntimeException("Can't add transaction from line: " + line, e);
            }
        }

        return transactions;
    }
}
