package core.basesyntax.dao;

import core.basesyntax.db.Storage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StorageDaoImpl implements StorageDao {
    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
    private String savedEntryTime;

    public String getSavedEntryTime() {
        return savedEntryTime;
    }

    public static void removeProduct(String fruit, int minuend) {
        Integer currentValue = Storage.foodStorage.get(fruit);

        if (currentValue != null && currentValue >= minuend) {
            Storage.foodStorage.put(fruit, currentValue - minuend);
        } else {
            throw new RuntimeException("Not enough " + fruit + " in the storage to remove from");
        }
    }

    public static void addProduct(String fruit, int addend) {
        Storage.foodStorage.merge(fruit, addend, Integer::sum);
    }

    public static void clear() {
        Storage.foodStorage.clear();
    }

    @Override
    public void addFile() {
        File serviceInput = new File("src" + File.separator
                + "main" + File.separator + "java" + File.separator
                + "core" + File.separator + "basesyntax" + File.separator + "db" + File.separator
                + "input_" + LocalDateTime.now().format(formatter) + ".csv");
        try {
            serviceInput.createNewFile();
            savedEntryTime = serviceInput.toPath().toString();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }
    }

    @Override
    public File writeReport() {
        try {
            Files.writeString(Path.of(getSavedEntryTime()),
                    "fruit,quantity\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error writing header to file for the timestamp " + getSavedEntryTime(), e);
        }

        Storage.foodStorage.entrySet().stream().forEach(e -> {
            try {
                String entry = e.getKey() + "," + e.getValue() + System.lineSeparator();
                Files.writeString(Path.of(getSavedEntryTime()), entry, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                throw new RuntimeException(
                        "Can't write data to file for the timestamp " + getSavedEntryTime(), ex);
            }
        });

        return Path.of(getSavedEntryTime()).toFile();
    }
}
