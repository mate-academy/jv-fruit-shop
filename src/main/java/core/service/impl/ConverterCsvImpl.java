package core.service.impl;

import core.model.Transaction;
import core.service.Converter;
import core.service.TransactionDao;
import java.util.ArrayList;
import java.util.List;

public class ConverterCsvImpl implements Converter {
    private static final int OPERATION_TYPE = 0;
    private static final int PRODUCT_NAME = 1;
    private static final int QUANTITY = 2;
    private static final int REQUIRED_LENGTH = 3;
    private final TransactionDao dao;
    
    public ConverterCsvImpl(TransactionDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Transaction> convertCsvLines(List<String> lines) {
        List<Transaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String[] parts = lines.get(i).split(",");
            if (parts.length != REQUIRED_LENGTH) {
                throw new IllegalArgumentException("Wrong number of columns in line " + i);
            }
            Transaction transaction = new Transaction(
                    Transaction.Operation.getOperationByCode(parts[OPERATION_TYPE].trim()),
                    parts[PRODUCT_NAME].trim(),
                    Integer.parseInt(parts[QUANTITY].trim())
            );
            transactions.add(transaction);
        }
        return transactions;
    }
}
