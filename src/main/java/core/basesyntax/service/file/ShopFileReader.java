package core.basesyntax.service.file;

import java.util.List;

public interface ShopFileReader {
    List<String> readCsv(String fileName);
}
