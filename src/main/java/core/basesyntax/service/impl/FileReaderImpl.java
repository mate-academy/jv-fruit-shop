package core.basesyntax.service.impl;

import core.basesyntax.service.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReaderImpl implements FileReader {
    @Override
    public List<String> read(String filePath) {
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(filePath))) {
            String line = br.readLine();
            List<String> lines = new ArrayList<>();
            while (line != null) {
                lines.add(line);
                line = br.readLine();
            }
            return lines;
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Can't read data from file" + filePath, ex);
        } catch (IOException ex) {
            throw new RuntimeException("IOException has happened in the file" + filePath, ex);
        }
    }
}
