package core.basesyntax.service.impl;

import core.basesyntax.service.Writer;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WriterCsvImpl implements Writer {

    private static final int HEADER_INDEX = 0;
    private String filename;

    public WriterCsvImpl(String filename) {
        this.filename = filename;
    }

    public void write(Map<String, Integer> reportData) {

        List<List<String>> data = reportData.entrySet().stream()
                .map(entry -> List.of(entry.getKey(), entry.getValue().toString()))
                .collect(Collectors.toList());

        List<String> header = List.of("fruit", "quantity");
        data.add(HEADER_INDEX, header);

        try (PrintWriter pw = new PrintWriter(new FileWriter(filename))) {
            for (List<String> line : data) {
                pw.println(String.join(",", line));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file by path: " + filename, e);
        } catch (IOException e) {
            throw new RuntimeException("Catch IOException: " + e);
        }
    }
}
