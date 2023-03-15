package core.basesyntax.service.impl;

import core.basesyntax.service.FileWorkerService;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileWorkerServiceImpl implements FileWorkerService {
    private static final String FILE_WRITE_TO = "src/main/resources/report.csv";
    private static final int INDEX_OF_CSV_HEADER = 0;

    public List<String> readFromFile(String fileName) {
        List<String> transactionInfo;
        try {
            transactionInfo = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName);
        }
        transactionInfo.remove(INDEX_OF_CSV_HEADER);
        return transactionInfo;
    }

    @Override
    public void createReport(List<String> products) {
        File file = new File(FILE_WRITE_TO);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file " + file, e);
        }

        for (String productInfo : products) {
            String dataToWrite = productInfo + System.lineSeparator();
            try {
                Files.write(file.toPath(), dataToWrite.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file " + file, e);
            }
        }
    }
}
