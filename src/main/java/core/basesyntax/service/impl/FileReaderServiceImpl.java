package core.basesyntax.service.impl;

import static core.basesyntax.service.impl.FileServiceImpl.getFromFile;

import core.basesyntax.service.ReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderServiceImpl implements ReaderService {

    @Override
    public String read() {
        StringBuilder builder = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(getFromFile()))) {
            String line = reader.readLine();
            while (line != null) {
                builder.append(line).append(System.lineSeparator());
                line = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file. " + e);
        }
        return builder.toString();
    }
}
