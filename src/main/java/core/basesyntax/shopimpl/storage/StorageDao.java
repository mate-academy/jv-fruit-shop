package core.basesyntax.shopimpl.storage;

import core.basesyntax.model.shopdao.ShopDao;
import core.basesyntax.model.shopstrategy.ShopActions;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StorageDao implements ShopDao<DataRecord> {
    private static final String FILE_DELIMITER = ",";
    private static final int FILE_INDEX_OF_ACTION = 0;
    private static final int FILE_INDEX_OF_ITEM = 1;
    private static final int FILE_INDEX_OF_AMOUNT = 2;
    
    private List<DataRecord> dataBase;
    private String dataFilePath;
    
    public StorageDao(String dataFilePath) {
        dataBase = parseFileLines(dataFilePath);
        this.dataFilePath = dataFilePath;
    }
    
    @Override
    public List<DataRecord> getAllActions() {
        return new ArrayList<>(dataBase);
    }
    
    @Override
    public List<DataRecord> getItemActions(String item) {
        return dataBase.stream()
                .filter(data -> data.item().equalsIgnoreCase(item))
                .collect(Collectors.toList());
    }
    
    @Override
    public void addAction(DataRecord action) {
        dataBase.add(action);
    }
    
    public void addAction(ShopActions action, String item, Integer amount) {
        dataBase.add(new DataRecord(action, item, amount));
    }
    
    @Override
    public void close() {
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
    
    private List<DataRecord> parseFileLines(String path) {
        List<DataRecord> records = new ArrayList<>();
        List<String> lines = readDataFile(path);
        
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
    
    private List<String> readDataFile(String path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong with reading file", e);
        }
        return lines;
    }
}
