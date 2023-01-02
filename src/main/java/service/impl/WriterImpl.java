package service.impl;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;
import service.Writer;

public class WriterImpl implements Writer {

    public static final String HEAD = "fruit,quantity";

    @Override
    public void writeReport(Map<String, Integer> fruitList, String report) {

        String frutReport = createReport(fruitList);

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(report))) {
            bufferedWriter.write(HEAD + "\n");
            bufferedWriter.write(frutReport);
        } catch (IOException e) {
            throw new RuntimeException("Can`t write data to file ", e);
        }
    }

    private String createReport(Map<String, Integer> fruitList) {
        return fruitList.entrySet().stream()
               .map(e -> e.getKey() + "," + e.getValue() + "\n")
               .collect(Collectors.joining());
    }
}
