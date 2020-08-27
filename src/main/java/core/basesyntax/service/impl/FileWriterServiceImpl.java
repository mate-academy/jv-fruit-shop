package core.basesyntax.service.impl;

import core.basesyntax.Storage;
import core.basesyntax.service.FileWriterService;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class FileWriterServiceImpl implements FileWriterService {
    private static final String[] HEADERS = {"fruit", "quantity"};

    @Override
    public void write(List<Storage.FruitBox> data, String fileName) {
        try (Writer writer = new PrintWriter(new File(fileName));
                CSVPrinter printer = new CSVPrinter(writer,
                        CSVFormat.DEFAULT.withHeader(HEADERS))) {
            List<String> fruitNames = data.stream()
                    .sorted()
                    .map(x -> x.getFruit().getName())
                    .distinct()
                    .collect(Collectors.toList());
            Map<String, Integer> rows = new HashMap<>();
            for (String name : fruitNames) {
                int quantitySum = data.stream()
                        .filter(x -> x.getFruit().getName().equals(name))
                        .mapToInt(Storage.FruitBox::getQuantity)
                        .sum();
                rows.put(name, quantitySum);
            }
            for (Map.Entry<String, Integer> row : rows.entrySet()) {
                printer.printRecord(row.getKey(), row.getValue());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Failed to write file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
