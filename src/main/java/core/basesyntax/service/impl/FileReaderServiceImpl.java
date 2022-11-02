package core.basesyntax.service.impl;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.IOException;

public class FileReaderServiceImpl implements ReaderService {
    private final BufferedReader bufferedReader;

    public FileReaderServiceImpl(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    @Override
    public String read() {
        StringBuilder builder = new StringBuilder();
        try (bufferedReader) {
            String line = bufferedReader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file. " + e);
        }
        return builder.toString();
    }
}
