package core.basesyntax.shopimpl.service;

import core.basesyntax.model.shopstrategy.ShopActions;
import core.basesyntax.shopimpl.database.DataRecord;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class IODataFileService {
    private static final String FILE_DELIMITER = ",";
    private static final int FILE_INDEX_OF_ACTION = 0;
    private static final int FILE_INDEX_OF_ITEM = 1;
    private static final int FILE_INDEX_OF_AMOUNT = 2;
    private String dataFilePath;
    
    public IODataFileService(String dataFilePath) {
        this.dataFilePath = dataFilePath;
    }
    
    public void writeDataFile(List<DataRecord> dataBase) {
        StringBuilder sb = new StringBuilder("");
        
        sb.append("ShopAction").append(FILE_DELIMITER)
                .append("Item").append(FILE_DELIMITER)
                .append("Amount");
        
        for (DataRecord record : dataBase) {
            sb.append(System.lineSeparator())
                    .append(record.action().toString()).append(FILE_DELIMITER)
                    .append(record.item()).append(FILE_DELIMITER)
                    .append(record.amount().toString());
        }
        
        try {
            Files.delete(Path.of(dataFilePath));
            Files.writeString(Path.of(dataFilePath), sb.toString(), StandardOpenOption.CREATE_NEW);
        } catch (IOException e) {
            throw new RuntimeException("A problem has occurred while writing the file");
        }
    }
    
    public List<DataRecord> readDataFile() {
        List<DataRecord> records = new ArrayList<>();
        List<String> lines = readFile();
        
        if (lines.isEmpty()) {
            return records;
        }
        
        for (int i = 1; i < lines.size(); i++) {
            String[] data = lines.get(i).split(FILE_DELIMITER);
            records.add(new DataRecord(ShopActions.valueOf(data[FILE_INDEX_OF_ACTION]),
                    data[FILE_INDEX_OF_ITEM],
                    Integer.parseInt(data[FILE_INDEX_OF_AMOUNT])));
        }
        
        return records;
    }
    
    private List<String> readFile() {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(dataFilePath));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading file", e);
        }
        return lines;
    }
}
