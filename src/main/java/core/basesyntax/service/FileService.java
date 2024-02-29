package core.basesyntax.service;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class FileService {
    private static final String INPUT_FILE_NAME = "src/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/output.csv";
    private static final int TYPE = 0;
    private static final int FRUIT = 1;
    private static final int QUANTITY = 2;
    private FruitTransactionDao fruitTransactionDao;

    public FileService() {
        this.fruitTransactionDao = new FruitTransactionDaoImpl();
    }

    public List<FruitTransaction> readFromFile() {
        return convertToTransactionsList(fruitTransactionDao.getAllTransactions(INPUT_FILE_NAME));
    }

    public boolean writeReport(String report) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_NAME));
            writer.append(report);
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return true;
    }

    private static List<FruitTransaction> convertToTransactionsList(List<String[]> lines) {
        return lines.stream()
                .map(f -> new FruitTransaction(OperationStrategy.getOperation(f[TYPE]),
                        f[FRUIT],
                        Integer.parseInt(f[QUANTITY])))
                .collect(Collectors.toList());
    }
}
