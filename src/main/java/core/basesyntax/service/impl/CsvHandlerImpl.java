package core.basesyntax.service.impl;

import core.basesyntax.service.FileHandler;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class CsvHandlerImpl implements FileHandler {
    @Override
    public List<String> readFile(Path filePath) {
        List<String> inputData;
        try {
            inputData = Files.readAllLines(filePath, Charset.defaultCharset());
        } catch (IOException e) {
            throw new RuntimeException("Something wrong went with the file: "
                    + filePath);
        }
        return inputData;
    }

    @Override
    public void writeCsv(List<String> report, Path toPath) {
        try {
            Files.write(toPath, report);
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong during writing"
                    + " process to file: " + toPath);
        }
    }
}
