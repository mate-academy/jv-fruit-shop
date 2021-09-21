package core.basesyntax.service;

import java.util.List;

public interface FruitShopCsv {
    void writeToFile(String fileName, String report);

    List<String> readFile(String fileName);
}
