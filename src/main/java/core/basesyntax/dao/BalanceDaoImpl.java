package core.basesyntax.dao;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Product;
import core.basesyntax.model.Transaction;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class BalanceDaoImpl implements BalanceDao {

    @Override
    public List<Transaction> getBalanceFromFile(String fileName) {
        Path filePath = Paths.get(fileName);
        List<String> readFromFile;
        try {
            readFromFile = Files.readAllLines(filePath);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + fileName, e);
        }
        return getTransactionList(readFromFile);
    }

    private List<Transaction> getTransactionList(List<String> fileLines) {
        return fileLines.stream()
                .filter(line -> Operation.fromString(line.split(",")[0]) != null)
                .map(this::getFromCsvRow)
                .collect(Collectors.toList());
    }

    private Transaction getFromCsvRow(String line) {
        String[] fields = line.split(",");
        Transaction transaction = new Transaction();
        transaction.setOperation(Operation.fromString(fields[0]));
        transaction.setProduct(new Product(fields[1]));
        transaction.setQuantity(Integer.parseInt(fields[2]));
        return transaction;
    }
}
