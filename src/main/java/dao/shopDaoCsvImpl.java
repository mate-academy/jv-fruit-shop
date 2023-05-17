package dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class shopDaoCsvImpl implements shopDao{
    private static final String filePath = "database.csv";

    @Override
    public List<String> getData() {
        List<String> infoFruitActionLine;
        try {
            infoFruitActionLine = Files.readAllLines(Paths.get(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Cant read data from file" + filePath);
        }
        return infoFruitActionLine;
    }
}
