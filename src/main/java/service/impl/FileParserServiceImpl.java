package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.FileParserService;

public class FileParserServiceImpl implements FileParserService {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public List<FruitTransaction> parseFileInformation(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            if (checkBeforeParse(line)) {
                String[] partsOfLine = line.split(SEPARATOR);
                FruitTransaction receivedTransaction = new FruitTransaction(FruitTransaction
                         .Operation.getOperationByCommand(partsOfLine[INDEX_OF_OPERATION]),
                               partsOfLine[INDEX_OF_FRUIT],
                         Integer.parseInt(partsOfLine[INDEX_OF_QUANTITY]));
                transactions.add(receivedTransaction);
            }
        }
        return transactions;
    }

    public boolean checkBeforeParse(String line) {
        return line != null && line.length() == 3;
    }
}
