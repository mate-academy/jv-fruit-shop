package core.basesyntax.shop.impl;

import core.basesyntax.shop.ReadFromFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromCsvFile implements ReadFromFile {

    @Override
    public String read(String fromFilename) {
        StringBuilder csvReadBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fromFilename))) {
            String line = bufferedReader.readLine();
            while (line != null) {
                csvReadBuilder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file", e);
        }
        return csvReadBuilder.toString().trim();
    }
}
