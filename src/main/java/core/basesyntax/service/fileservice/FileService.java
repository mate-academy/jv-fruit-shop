package core.basesyntax.service.fileservice;

import core.basesyntax.dao.FruitDao;
import java.util.List;

public interface FileService {
    List<String> readAllLinesFromFile(String fromFile);

    String createReport(FruitDao fruitDao);

    void writeReport(String toFile);
}
