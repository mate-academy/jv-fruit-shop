package core.basesyntax.service.impl;

import core.basesyntax.service.FileReaderService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileReaderServiceImpl implements FileReaderService {
    @Override
    public List<String> read(String filePath) {
        List<String> lines = new ArrayList<>();
        try (InputStreamReader isr = new InputStreamReader(
                Objects.requireNonNull(
                        Thread.currentThread().getContextClassLoader()
                                .getResourceAsStream(filePath)
                ), StandardCharsets.UTF_8);
                BufferedReader br = new BufferedReader(isr)) {

            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
        return lines;
    }
}
