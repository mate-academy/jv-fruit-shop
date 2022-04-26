package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.CsvFileWriterService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CsvFileWriterServiceImpl implements CsvFileWriterService {
    public static final String COLUMN = "fruit,quantity";

    @Override
    public void fileWriter(String fileName) {
        File file = new File(fileName);
        for (int i = 0; i < getReportFromList().size(); i++) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file))) {
                bufferedWriter.write(getReportFromList().get(i));
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file!");
            }
        }
    }

    private static List<String> getReportFromList() {
        StringBuilder builder = new StringBuilder();
        builder.append(COLUMN)
                .append(System.lineSeparator());
        List<String> fromMapToList = new ArrayList<>();
        for (Map.Entry<String, Integer> output : Storage.fruitStorage.entrySet()) {
            builder.append(output.getKey())
                    .append(",")
                    .append(output.getValue())
                    .append(System.lineSeparator());
            fromMapToList.add(builder.toString());
        }
        return fromMapToList;
    }
}
