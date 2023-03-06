package core.basesyntax.service.impl;

import core.basesyntax.service.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReaderImpl implements Reader {
    private static final String DELIMITER = "///";

    @Override
    public String readerTransaction(String fileName) {
        StringBuilder stringBuilder = new StringBuilder();
        try (BufferedReader bufferedReader = new BufferedReader((new FileReader(fileName)))) {
            String text = bufferedReader.readLine();
            while (text != null) {
                stringBuilder.append(text).append(DELIMITER);
                text = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can`open file" + fileName, e);
        }
        return stringBuilder.toString();
    }
}
