package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Cannot find file: " + path, e);
        } catch (IOException e) {
            throw new RuntimeException("Cannot read file: " + path, e);
        }
        if (lines.size() == 0) {
            throw new RuntimeException("File " + path + " is empty");
        }
        return lines;
    }
}
