package core.basesyntax.impl;

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
    private static final String FILE_NAME
            = "src/main/java/core/basesyntax/resources/inputDataForPeriod.csv";
    private static final String SEPARATE = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;

    private Transaction getFruitTransaction(String line) {
        List<Operation> operations = new OperationDaoImpl().getListOperations();
        String[] fields = line.split(SEPARATE);
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
        return list
                .stream()
                .filter(l -> !l.isEmpty())
                .map(this::getFruitTransaction)
                .collect(Collectors.toList());
    }
}
