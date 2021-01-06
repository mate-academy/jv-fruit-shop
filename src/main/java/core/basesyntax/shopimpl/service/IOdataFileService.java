package core.basesyntax.shopimpl.service;

import core.basesyntax.model.abstractstorage.AbstractItem;
import core.basesyntax.model.shopstrategy.ShopTransactionsType;
import core.basesyntax.shopimpl.entity.DataRecord;
import core.basesyntax.shopimpl.entity.Fruit;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class IOdataFileService {
    private static final String FILE_DELIMITER = ",";
    private static final String NUMBERS_PATTERN = "[^0-9]";
    private static final int FILE_INDEX_OF_ACTION = 0;
    private static final int FILE_INDEX_OF_ITEM = 1;
    private static final int FILE_INDEX_OF_AMOUNT = 2;
    
    public void writeReport(String path, Map<AbstractItem, Integer> storage) {
        StringBuilder sb = new StringBuilder();
        sb.append("Item").append(FILE_DELIMITER)
                .append("Amount")
                .append(System.lineSeparator());
        for (Map.Entry<AbstractItem, Integer> entry : storage.entrySet()) {
            sb.append(entry.getKey()).append(FILE_DELIMITER)
                    .append(entry.getValue()).append(FILE_DELIMITER)
                    .append(System.lineSeparator());
        }
        try {
            Files.write(Path.of(path),
                    sb.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
        } catch (IOException e) {
            throw new RuntimeException("A problem has occurred while writing the file");
        }
    }
    
    public List<DataRecord> parseAll(List<String> lines) {
        List<DataRecord> records = new ArrayList<>();
        if (lines.isEmpty()) {
            return records;
        }
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) {
                continue;
            }
            records.add(parseToRecord(lines.get(i)));
        }
        return records;
    }
    
    public DataRecord parseToRecord(String line) {
        String[] data = line.split(FILE_DELIMITER);
        if (data[FILE_INDEX_OF_AMOUNT].matches(NUMBERS_PATTERN)
            || Integer.parseInt(data[FILE_INDEX_OF_AMOUNT]) < 0) {
            throw new IllegalArgumentException("The file line doesn't"
                                               + " contain proper values or fields");
        }
        return new DataRecord(ShopTransactionsType.getAction(data[FILE_INDEX_OF_ACTION]),
                new Fruit(data[FILE_INDEX_OF_ITEM]),
                Integer.parseInt(data[FILE_INDEX_OF_AMOUNT]));
    }
    
    public List<String> readFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading file", e);
        }
        return lines;
    }
}
