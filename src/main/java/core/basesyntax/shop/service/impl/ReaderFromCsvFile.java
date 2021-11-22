package core.basesyntax.shop.service.impl;

import core.basesyntax.shop.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromCsvFile implements Reader {

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
            throw new RuntimeException("Can't read from file" + fromFilename, e);
        }
        return csvReadBuilder.toString().trim();
    }
}
