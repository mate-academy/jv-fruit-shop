package core.basesyntax.service;

import core.basesyntax.exception.ReadFileException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvFileReader implements FilesReader {
    @Override
    public String read(String fileName) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            StringBuilder stringBuilder = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(System.lineSeparator());
            }
            return stringBuilder.toString();
        } catch (IOException e) {
            throw new ReadFileException("Can't read read file " + fileName);
        }
    }
}
