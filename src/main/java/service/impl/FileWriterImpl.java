package service.impl;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.FileWriter;
import service.ReportGenerator;
import service.ShopService;

public class FileWriterImpl implements FileWriter {
    private final FileReader fileReader;
    private final DataConverter dataConverter;
    private final ShopService shopService;
    private final ReportGenerator reportGenerator;

    public FileWriterImpl(FileReader fileReader, DataConverter dataConverter,
                          ShopService shopService, ReportGenerator reportGenerator) {
        this.fileReader = fileReader;
        this.dataConverter = dataConverter;
        this.shopService = shopService;
        this.reportGenerator = reportGenerator;
    }

    @Override
    public void write(String path, String content) throws IOException {
        List<String> readingFile = fileReader.read(path);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readingFile);
        shopService.process(transactions);
        String report = reportGenerator.getReport();

        try (BufferedWriter writer =
                     new BufferedWriter(new OutputStreamWriter(
                             new FileOutputStream(path), StandardCharsets.UTF_8))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Error to write file!" + path);
        }
    }
}
