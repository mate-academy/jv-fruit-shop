package impl;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import model.Operation;
import service.TransactionParser;

public class TransactionParserImpl implements TransactionParser {
    private static final int HEADER_INDEX_IN_INITIAL_FILE = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> parseTransactions(List<String> fileInfo) {
        return reformatFileInfo(fileInfo).stream()
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private List<String[]> reformatFileInfo(List<String> fileInfo) {
        fileInfo.remove(HEADER_INDEX_IN_INITIAL_FILE);
        return fileInfo.stream()
                .map(str -> str.split(","))
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String[] line) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation(Operation
                .getOperation(line[OPERATION_INDEX].trim()));
        fruitTransaction.setFruit(line[FRUIT_INDEX]);
        fruitTransaction.setQuantity(Integer.parseInt(line[QUANTITY_INDEX]));
        return fruitTransaction;
    }
}
