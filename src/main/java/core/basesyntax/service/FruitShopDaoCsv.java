package core.basesyntax.service;

import java.util.List;

public interface FruitShopDaoCsv {
    void writeToFile(String fileName, String report);

    List<String> readFile(String fileName);
}
