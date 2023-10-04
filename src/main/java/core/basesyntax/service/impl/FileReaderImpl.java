package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderImpl implements FileReaderService {

    @Override
    public FileReaderResult readFile(String inputFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            StringBuilder contentBuilder = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                contentBuilder.append(line).append("\n");
            }
            return new FileReaderResult(contentBuilder.toString());
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file ", e);
        }
    }
}
