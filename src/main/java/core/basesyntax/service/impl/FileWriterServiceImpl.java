package core.basesyntax.service.impl;

import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Map;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String[] HEADERS = {"fruit", "quantity"};

    @Override
    public void write(Map<String, Integer> data, String fileName) {
        try (Writer writer = new PrintWriter(new File(fileName));
                CSVPrinter printer = new CSVPrinter(writer,
                        CSVFormat.DEFAULT.withHeader(HEADERS))) {
            for (Map.Entry<String, Integer> row : data.entrySet()) {
                printer.printRecord(row.getKey(), row.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to write file");
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
