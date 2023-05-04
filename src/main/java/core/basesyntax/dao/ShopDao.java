package core.basesyntax.dao;

import java.io.File;
import java.util.List;

public interface ShopDao {
    public List<String> readData();
    void writeReport();
}
