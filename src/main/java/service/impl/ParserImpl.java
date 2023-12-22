package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.Parser;

public class ParserImpl implements Parser {
    private static final int COLUMN_WITH_OPERATION_CODE = 0;
    private static final int COLUMN_WITH_FRUIT = 1;
    private static final int COLUMN_WITH_QUANTITY = 2;
    private static final int TOTAL_COLUMNS = 3;
    private static final String EXPECTED_REPORT_HEADER = "type,fruit,quantity";

    @Override
    public List<FruitTransaction> getTransactions(String transactionsData) {
        List<FruitTransaction> transactions = new ArrayList<>();
        String[] linesArray = transactionsData.split(System.lineSeparator());

        if (linesArray.length == 0) {
            return transactions;
        }

        if (linesArray[0] == null || !linesArray[0].equals(EXPECTED_REPORT_HEADER)) {
            throw new RuntimeException("Can't parse data."
                    + " Unexpected report header: " + linesArray[0]);
        }

        for (int i = 1; i < linesArray.length; i++) {
            String line = linesArray[i];
            String[] lineData = line.split(",");
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
