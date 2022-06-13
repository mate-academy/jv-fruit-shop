package mate.academy.dao;

import java.util.List;

public interface ShopDao {
    List<String> readFromDb();

    void createFileForReport();
}
