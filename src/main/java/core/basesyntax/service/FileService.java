package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private FruitTransactionDao fruitTransactionDao;

    public FileService() {
        this.fruitTransactionDao = new FruitTransactionDaoImpl();
    }

    public List<String[]> readFromFile() {
        return fruitTransactionDao.getAllTransactions(INPUT_FILE_NAME);
    }

    public boolean writeReport(String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));) {
            writer.append(report);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    public static List<FruitTransaction> convertToTransactionsList(List<String[]> lines) {
        return lines.stream()
                .map(line -> new FruitTransaction(FruitTransaction.Operation
                        .getOperation(line[TYPE_INDEX]),
                        line[FRUIT_INDEX],
                        Integer.parseInt(line[QUANTITY_INDEX])))
                .collect(Collectors.toList());
    }
}
