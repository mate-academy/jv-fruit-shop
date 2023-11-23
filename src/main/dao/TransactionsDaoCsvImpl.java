package main.dao;

import main.model.ProductTransaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TransactionsDaoCsvImpl implements TransactionsDao {
    private static final int TITLE_ROW_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private String filePath;

    public TransactionsDaoCsvImpl(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Map<String, List<ProductTransaction>> get() {
        List<String> transaction;
        try {
            transaction = Files.readAllLines(Path.of(filePath));
            transaction.remove(TITLE_ROW_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + filePath);
        }
        return transaction.stream()
            .map(this::getFromCsvRow)
            .collect(Collectors.groupingBy(ProductTransaction::getProductName, Collectors.toList()));
    }

    private ProductTransaction getFromCsvRow(String row) {
        String[] fields = row.split(SEPARATOR);
        ProductTransaction productTransaction = new ProductTransaction();
        productTransaction.setOperation(getOperationType(fields[OPERATION_INDEX].trim()));
        productTransaction.setProductName(fields[PRODUCT_NAME_INDEX].trim());
        productTransaction.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX].trim()));
        return productTransaction;
    }

    private ProductTransaction.Operation getOperationType(String operationCode) {
        return switch (operationCode) {
            case "b" -> ProductTransaction.Operation.BALANCE;
            case "s" -> ProductTransaction.Operation.SUPPLY;
            case "p" -> ProductTransaction.Operation.PURCHASE;
            case "r" -> ProductTransaction.Operation.RETURN;
            default -> throw new RuntimeException("Unsupported transaction type: " + operationCode);
        };
    }
}
