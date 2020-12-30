package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FileWriterServiceImpl implements FileWriterService {

    @Override
    public void writeToFile(String fileName, String text) {
        try (PrintWriter printer = new PrintWriter(fileName)) {
            printer.print(text);
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Something wrong with writing to file");
        }
    }
}
