package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ShopServiceStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StorageDaoImpl implements StorageDao {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm");
    private String savedEntryTime;

    public String getSavedEntryTime() {
        return savedEntryTime;
    }

    public static void removeProduct(ShopServiceStrategy.Operation type, int minuend) {
        Integer currentValue = Storage.foodStorage.get(type);

        if (currentValue != null && currentValue >= minuend) {
            Storage.foodStorage.put(type, currentValue - minuend);
        } else throw new RuntimeException("Not enough " + type + " in the storage to remove from");
    }

    public static void addProduct(ShopServiceStrategy.Operation type, int addend) {
        Integer currentValue = Storage.foodStorage.get(type);
        if (currentValue != null) {
            Storage.foodStorage.put(type, currentValue + addend);
        } else {
            Storage.foodStorage.put(type, addend);
        }
    }

    public static void clear() {
        Storage.foodStorage.clear();
    }

    @Override
    public void addFile() {
        File entries = new File("src" + File.separator + "main" + File.separator + "java" + File.separator
                + "core" + File.separator + "basesyntax" + File.separator + "db" + File.separator
                + "input_" + LocalDateTime.now().format(formatter) + ".txt");
        try {
            entries.createNewFile();
            savedEntryTime = "src" + File.separator + "main" + File.separator + "java" + File.separator
                    + "core" + File.separator + "basesyntax" + File.separator + "db" + File.separator
                    + "input_" + LocalDateTime.now().format(formatter) + ".txt";
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }
        Storage.list.add(entries);
    }

    @Override
    public File createReport() {
        Storage.foodStorage.entrySet().stream().forEach(e -> {
            try {
                String entry = e.getKey().toString() + ", " + e.getValue() + System.lineSeparator();
                Files.writeString(Path.of(getSavedEntryTime()), entry, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                throw new RuntimeException("Can't write data to file for the timestamp " + getSavedEntryTime(), ex);
            }
        });

        return Storage.list.get(Storage.list.size() - 1);
    }
}
