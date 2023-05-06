package core.basesyntax.service;

import core.basesyntax.db.Storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class FileServiceImpl implements FileService {
    private static final String MASSAGE = "Can't get data from file ";
    private static final String MASSAGE_OF_EXCESSIVE_QUANTITY = "Check the "
            + "data is a negative quantity of the product";

    @Override
    public void write(String data, String fileName) {
        if (Storage.remnantsOfGoods.values().stream().allMatch(value -> value < 0)) {
            throw new RuntimeException(MASSAGE_OF_EXCESSIVE_QUANTITY);
        }
        try {
            Files.write(Paths.get(fileName), data.getBytes(),
                    StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException(fileName);
        }
    }

    @Override
    public List<String> read(String fileName) {
        List<String> stringList;
        try {
            stringList = Files.readAllLines(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException(MASSAGE + fileName);
        }
        return stringList;
    }
}
