package core.basesyntax.service.impl;

import core.basesyntax.db.ShopStorage;
import core.basesyntax.service.ReportGenerationService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FruitReportGenerationServiceImpl implements ReportGenerationService {
    private static final String FIRST_LINE = "fruit, quantity";
    private static final String PATH_SEPARATOR = "/";
    private final ShopStorage<?> storage;

    public FruitReportGenerationServiceImpl(ShopStorage<?> storage) {
        this.storage = storage;
    }

    @Override
    public void generateReport(String path, String fileName) {
        try (FileWriter writer = prepareFileForWritingReport(path, fileName)) {
            writeHeader(writer);
            writeMainInfo(writer, storage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private FileWriter prepareFileForWritingReport(String filePath, String fileName) {
        File file = new File(filePath + PATH_SEPARATOR + fileName);
        try {
            file.createNewFile();
            return new FileWriter(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void writeHeader(FileWriter writer) throws IOException {
        writer.write(FIRST_LINE);
        writer.write(System.lineSeparator());
        writer.flush();
    }

    private <T> void writeMainInfo(FileWriter fileWriter, ShopStorage<T> storage) {
        for (T item : storage.getAllItems()) {
            try {
                fileWriter.write(item.toString().toLowerCase() + "," + storage.getAmount(item));
                fileWriter.write(System.lineSeparator());
                fileWriter.flush();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
