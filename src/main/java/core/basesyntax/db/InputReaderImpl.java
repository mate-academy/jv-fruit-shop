package core.basesyntax.db;

import core.basesyntax.exception.InputReadException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class InputReaderImpl implements InputReader {
    @Override
    public String readInputCsv(String pathToFile) {
        File file = new File(pathToFile);
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String value = br.readLine();
            if (value != null) {
                // Skip column names
                value = br.readLine();
            }
            while (value != null) {
                result.append(value).append(System.lineSeparator());
                value = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new InputReadException("Can't find file " + pathToFile, e);
        } catch (IOException e) {
            throw new InputReadException("Can't read from file " + pathToFile, e);
        }
        return result.toString().trim();
    }
}
