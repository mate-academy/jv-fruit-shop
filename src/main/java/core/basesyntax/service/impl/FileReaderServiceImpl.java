package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.TransactionLog;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReaderServiceImpl implements FileReaderService {
    private static final String COMA_SEPARATOR = ",";
    private static final int TYPE_OPERATION_INDEX = 0;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int FRUIT_VALUE_INDEX = 2;
    private static final int HEAD_INDEX = 0;

    @Override
    public List<TransactionLog> readFromFile(String filepath) {
        List<TransactionLog> transactionsList = new ArrayList<>();
        List<String> linesList = dataFromFile(filepath);
        linesList.remove(HEAD_INDEX);
        for (String line : linesList) {
            String[] strLineArray = line.split(COMA_SEPARATOR);
            TransactionLog transaction = new TransactionLog(strLineArray[TYPE_OPERATION_INDEX],
                    strLineArray[FRUIT_NAME_INDEX],
                    Integer.parseInt(strLineArray[FRUIT_VALUE_INDEX]));
            transactionsList.add(transaction);
        }
        return transactionsList;
    }

    private List<String> dataFromFile(String filepath) {
        try {
            return Files.readAllLines(Paths.get(filepath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can`t find a file: " + filepath);
        } catch (IOException e) {
            throw new RuntimeException("Can`t read data from file: " + filepath);
        }
    }
}
