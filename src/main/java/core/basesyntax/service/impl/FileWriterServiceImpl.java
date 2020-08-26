package core.basesyntax.service.impl;

import core.basesyntax.model.Fruit;
import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String[] HEADERS = {"fruit", "quantity"};

    @Override
    public void write(List<Fruit> data, String fileName) {
        try (Writer writer = new PrintWriter(new File(fileName));
                CSVPrinter printer = new CSVPrinter(writer,
                        CSVFormat.DEFAULT.withHeader(HEADERS))) {
            for (Fruit row : data) {
                printer.printRecord(List.of(row.getName(), row.getQuantity()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
