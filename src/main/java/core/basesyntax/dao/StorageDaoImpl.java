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
    public String addFile(String sourceFilePath) {
        File reportFolder = new File("src" + File.separator
                + "main" + File.separator
                + "resources" + File.separator
                + "report_" + LocalDateTime.now().format(formatter));

        File serviceInput = new File(reportFolder.toPath()
                + File.separator
                + "input_" + LocalDateTime.now().format(formatter) + ".csv");

        File serviceOutput = new File(serviceInput.toPath().toString().replace("input", "output"));
        try {
            reportFolder.mkdir();
            serviceInput.createNewFile();
            Files.write(serviceInput.toPath(), Files.readAllLines(Path.of(sourceFilePath)));
            serviceOutput.createNewFile();
            return serviceOutput.toPath().toString();
        } catch (IOException e) {
            throw new RuntimeException("Cannot create a new file", e);
        }
    }
    @Override
    public File writeReport(String destinationPath) {
        String timeStamp = destinationPath.substring(destinationPath.indexOf('_') + 1,
                destinationPath.indexOf('.'));
        try {
            Files.writeString(Path.of(destinationPath),
                    "fruit,quantity\n", StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException(
                    "Error writing header to file for the timestamp " + timeStamp, e);
        }

        Storage.foodStorage.entrySet().stream().forEach(e -> {
            try {
                String entry = e.getKey() + "," + e.getValue() + System.lineSeparator();
                Files.writeString(Path.of(destinationPath), entry, StandardOpenOption.APPEND);
            } catch (IOException ex) {
                throw new RuntimeException(
                        "Can't write data to file for the timestamp " + timeStamp, ex);
            }
        });

        return Path.of(destinationPath).toFile();
    }
}
