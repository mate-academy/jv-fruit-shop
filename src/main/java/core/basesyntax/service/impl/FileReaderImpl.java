package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {

    @Override
    public List<String> read(String path) {
        List<String> linesString = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesString.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return linesString;
    }
}
