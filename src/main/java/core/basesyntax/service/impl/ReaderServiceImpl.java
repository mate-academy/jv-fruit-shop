package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderServiceImpl implements ReaderService {
    @Override
    public String readFrom(String pathToFile) {
        if (pathToFile == null) {
            throw new RuntimeException("Argument is null");
        }
        File file = new File(pathToFile);
        StringBuilder result = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String value = br.readLine();
            while (value != null) {
                result.append(value).append(System.lineSeparator());
                value = br.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't find file " + pathToFile, e);
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file " + pathToFile, e);
        }
        return result.toString().trim();
    }
}
