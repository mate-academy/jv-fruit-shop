package mate.academy.dao;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ShopDaoImpl implements ShopDao {
    private static final String PATH_NAME_DB = "src/main/java/mate/academy/db/database.csv";
    private static final String PATH_NAME_REPORT = "src/main/java/mate/academy/report/report.csv";

    @Override
    public List<String> readFromDb() {
        try {
            return Files.readAllLines(Path.of(PATH_NAME_DB));
        } catch (IOException e) {
            throw new RuntimeException("Can't read from: " + PATH_NAME_DB);
        }
    }

    @Override
    public void createFileForReport() {
        File report = new File(PATH_NAME_REPORT);
        try {
            report.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create a file");
        }
    }
}
