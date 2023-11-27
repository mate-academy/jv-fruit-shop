package main.dao;

import main.model.Product;
import main.model.Transaction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ProductDaoCsvImpl implements ProductDao {
    private static final int TITLE_ROW_INDEX = 0;
    private static final int TRANSACTION_CODE_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private String filePath;

    public ProductDaoCsvImpl(String filePath, ReportDao reportDao) {
        this.filePath = filePath;
    }

    @Override
    public List<Product> get() {
        List<String> products;
        try {
            products = Files.readAllLines(Path.of(filePath));
            products.remove(TITLE_ROW_INDEX);
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file: " + filePath);
        }
        return products.stream()
            .map(this::getProductFromCsvRow)
            .collect(Collectors.toList());
    }

    private Product getProductFromCsvRow(String row) {
        String[] fields = row.split(SEPARATOR);
        Product product = new Product();
        product.setTransaction(Transaction.getTransactionByCode(fields[TRANSACTION_CODE_INDEX].trim()));
        product.setProductName(fields[PRODUCT_NAME_INDEX].trim());
        product.setQuantity(Integer.parseInt(fields[QUANTITY_INDEX].trim()));
        return product;
    }
}
