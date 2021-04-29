package core.basesyntax.files;

import core.basesyntax.service.FruitService;
import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriterImpl implements FileWriter {
    private static final String WRITE_EXCEPTION_MESSAGE = "Can`t write to file ";
    private FruitService fruitService;

    public FileWriterImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public void writeToReport(String reportPath) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(reportPath))) {
            writer.write(fruitService.generateReport());
        } catch (IOException e) {
            throw new RuntimeException(WRITE_EXCEPTION_MESSAGE + reportPath, e);
        }
    }
}
