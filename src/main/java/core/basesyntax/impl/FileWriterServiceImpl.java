package core.basesyntax.impl;

import core.basesyntax.service.FileWriterService;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void parse(List<String[]> report) {
//        try (FileWriter writer = new FileWriter("file.csv")) {
//            BufferedWriter bufferedWriter = new BufferedWriter(writer);
//            bufferedWriter.write(String.valueOf(report));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        File csvOutputFile = new File("file.csv");
        try (PrintWriter pw = new PrintWriter(csvOutputFile)) {
            report.stream()
                    .map(this::convertToCSV)
                    .forEach(pw::println);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public String convertToCSV(String[] data) {
        return Stream.of(data)
                .map(this::escapeSpecialCharacters)
                .collect(Collectors.joining(","));
    }
    public String escapeSpecialCharacters(String data) {
        String escapedData = data.replaceAll("\\R", " ");
        if (data.contains(",") || data.contains("\"") || data.contains("'")) {
            data = data.replace("\"", "\"\"");
            escapedData = "\"" + data + "\"";
        }
        return escapedData;
    }
}
