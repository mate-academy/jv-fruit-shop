package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.service.CsvReportService;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

public class CsvReportServiceImpl implements CsvReportService {
    private FruitStorageDao fruitStorageDao;

    public CsvReportServiceImpl(FruitStorageDao fruitStorageDao) {
        this.fruitStorageDao = fruitStorageDao;
    }

    @Override
    public void writeReport(Path path) {
        Map<String, Integer> map = fruitStorageDao.getAllAsMap();
        File file = new File(path.toUri());
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("fruit,quantity\n");
            for (Map.Entry<String, Integer> entry : map.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue() + "\n");
            }
            writer.close();
            System.out.println("File created at: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new RuntimeException("File not generated at: " + path, e);
        }
    }
}
