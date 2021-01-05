package core.basesyntax.shopimpl.service;

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

public class IOdataFileService {
    private static final String FILE_DELIMITER = ",";
    private static final int FILE_INDEX_OF_ACTION = 0;
    private static final int FILE_INDEX_OF_ITEM = 1;
    private static final int FILE_INDEX_OF_AMOUNT = 2;
    
    public static void writeDataFile(String path, List<DataRecord> dataBase) {
        StringBuilder sb = new StringBuilder();
        sb.append("ShopAction").append(FILE_DELIMITER)
                .append("Item").append(FILE_DELIMITER)
                .append("Amount")
                .append(System.lineSeparator());
        for (DataRecord record : dataBase) {
            sb.append(record.getAction().getValue()).append(FILE_DELIMITER)
                    .append(record.getItem().getItemName()).append(FILE_DELIMITER)
                    .append(record.getAmount().toString())
                    .append(System.lineSeparator());
        }
        try {
            
            Files.write(Path.of(path),
                    sb.toString().getBytes(StandardCharsets.UTF_8), StandardOpenOption.CREATE);
            
        } catch (IOException e) {
            throw new RuntimeException("A problem has occurred while writing the file");
        }
    }
    
    public static List<DataRecord> readDataFile(String path) {
        List<DataRecord> records = new ArrayList<>();
        List<String> lines = readFile(path);
        if (lines.isEmpty()) {
            return records;
        }
        for (int i = 1; i < lines.size(); i++) {
            if (lines.get(i).isEmpty()) {
                continue;
            }
            String[] data = lines.get(i).split(FILE_DELIMITER);
            if (data[FILE_INDEX_OF_AMOUNT].matches("[^0-9]")
                    || Integer.parseInt(data[FILE_INDEX_OF_AMOUNT]) < 0) {
                throw new IllegalArgumentException("The file line doesn't"
                                                   + " contain proper values or fields");
            }
            records.add(new DataRecord(ShopTransactionsType.getAction(data[FILE_INDEX_OF_ACTION]),
                    new Fruit(data[FILE_INDEX_OF_ITEM]),
                    Integer.parseInt(data[FILE_INDEX_OF_AMOUNT])));
        }
        return records;
    }
    
    private static List<String> readFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading file", e);
        }
        return lines;
    }
}
