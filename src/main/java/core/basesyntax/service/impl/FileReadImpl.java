package core.basesyntax.service.impl;

import core.basesyntax.service.FileRead;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReadImpl implements FileRead {
    @Override
    public List<String> read(String fileName) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                lines.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(("File doesn't exist: " + e.getMessage()));
        } catch (IOException ioException) {
            throw new RuntimeException("Cannot read file '" + fileName
                    + "': " + ioException.getMessage());
        }
        return lines;
    }
}
