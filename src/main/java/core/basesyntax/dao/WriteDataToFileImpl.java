package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class WriteDataToFileImpl implements WriteDataToFile {
    private static final String FIRST_LINE = "fruit,quantity";
    private static final String FILE_PATH = "src/main/java/core/basesyntax/resources/NewReport.csv";

    @Override
    public void writeDataToFile(Map<Fruit, Integer> dataToUpdateReport) {
        File file = new File(FILE_PATH);
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create new file " + file, e);
        }
        try {
            Files.write(file.toPath(), (FIRST_LINE + System.lineSeparator()).getBytes(),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file " + file, e);
        }
        for (Map.Entry<Fruit, Integer> entry : dataToUpdateReport.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Quantity of " + entry.getKey()
                        + " can't be less than 0");
            }
            String string = entry.getKey().toString().toLowerCase() + "," + entry.getValue();
            try {
                Files.write(file.toPath(), (string + System.lineSeparator()).getBytes(),
                        StandardOpenOption.APPEND);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file " + file, e);
            }
        }
    }
}
