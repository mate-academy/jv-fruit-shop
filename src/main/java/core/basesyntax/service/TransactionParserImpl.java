package core.basesyntax.service;

import core.basesyntax.operation.TransactionProvider;
import core.basesyntax.operation.TransactionProviderImpl;
import core.basesyntax.operation.Transaction;
import java.util.ArrayList;
import java.util.List;

public class TransactionParserImpl implements TransactionParser {
    private static final int OPERATION_POSITION = 0;
    private static final int COLUMN_NAMES_LINE_INDEX = 0;
    private static final int PRODUCT_POSITION = 1;
    private static final int QUANTITY_POSITION = 2;
    private TransactionProvider transactionProvider = new TransactionProviderImpl();

    @Override
    public List<Transaction> parse(List<String> fileData) {
        if (fileData == null) {
            throw new RuntimeException("Input data is null");
        }
        fileData.remove(COLUMN_NAMES_LINE_INDEX);
        List<Transaction> operationsList = new ArrayList<>();
        for (String line : fileData) {
            String[] splitLine = line.split(",");            
            operationsList.add(createOperation(splitLine));
        }
        return operationsList;
    }

    private Transaction createOperation(String[] splitLine) {
        Transaction operation = new Transaction();
        operation.setOperation(transactionProvider.get(splitLine[OPERATION_POSITION]));
        operation.setProduct(splitLine[PRODUCT_POSITION]);
        operation.setQuantity(Integer.parseInt(splitLine[QUANTITY_POSITION]));
        return operation;
    }
}
