package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReaderCsv implements Reader {

    @Override
    public List<String> readData(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
            return filterTitles(lines);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file");
        }
    }

    private static List<String> filterTitles(List<String> data) {
        return data.stream()
                .skip(1)
                .collect(Collectors.toList());
    }

}
