package core.basesyntax.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private static final int TITLE_INDEX = 0;
    private List<String> lines = new ArrayList<>();

    @Override
    public List<String> fileReader(String fileSource) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileSource))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("An error occurred when reading the file: " + fileSource);
        }
        lines.remove(TITLE_INDEX);
        return lines;
    }
}
