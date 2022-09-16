package dao;

import java.io.File;
import java.util.List;

public interface ShopDao {
    List<String> readFromFile(File file);

    void writeToFile(File file, String data);
}
