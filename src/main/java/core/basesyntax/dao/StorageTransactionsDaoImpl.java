package core.basesyntax.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StorageTransactionsDaoImpl implements StorageTransactionsDao {
    @Override
    public List<String[]> convertFileIntoList(File inputFile) {
        List<String> inputData;
        try {
            inputData = Files.readAllLines(inputFile.toPath());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file " + inputFile);
        }
        return inputData.stream()
                .map(i -> i.split(","))
                .collect(Collectors.toList());
    }

    @Override
    public File sentReport(String data) {
        String nameFile = "Report " + LocalDate.now();
        File reportFile = new File(nameFile);
        try {
            reportFile.createNewFile();
            Files.write(reportFile.toPath(), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return reportFile;
    }

    @Override
    public String formingReport(Map<String, Integer> info) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : info.entrySet()) {
            stringBuilder.append(entry.getKey())
                    .append(",")
                    .append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
