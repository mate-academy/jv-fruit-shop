package core.basesyntax.service.impl;

import core.basesyntax.dao.OperationDaoImpl;
import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.ReaderService;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderServiceImpl implements ReaderService {
    private static final String FILE_NAME = "src/main/resources/allTransactionForPeriod.csv";
    private static final int INDEX_FIRST_LINE = 0;
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String COMMA_SEPARATOR = ",";

    private Transaction getTransaction(String line) {
        List<Operation> operations = new OperationDaoImpl().getListOperations();
        String[] fields = line.split(COMMA_SEPARATOR);
        Transaction transaction = new Transaction(fields[INDEX_FRUIT],
                Integer.parseInt(fields[INDEX_QUANTITY].trim()));
        for (Operation operation : operations) {
            if (operation.getShortName().equals(fields[INDEX_OPERATION].trim())) {
                transaction.setOperation(operation);
                break;
            }
        }
        return transaction;
    }

    @Override
    public List<Transaction> getListTransaction() {
        List<String> list;
        try {
            list = Files.readAllLines(Path.of(FILE_NAME));
        } catch (IOException e) {
            throw new RuntimeException("Can't get data from file " + FILE_NAME);
        }
        list.remove(INDEX_FIRST_LINE);
        return list.stream()
                .filter(l -> !l.isEmpty())
                .map(this::getTransaction)
                .collect(Collectors.toList());
    }
}
