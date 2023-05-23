package core.basesyntax.application;

import core.basesyntax.dao.ReadDao;
import core.basesyntax.dao.WriteDao;
import core.basesyntax.dao.impl.CsvReadDaoImpl;
import core.basesyntax.dao.impl.CsvWriteDaoImpl;
import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.util.List;
import java.util.Map;

public class Application {
    private FruitService fruitService;
    private Parser parser;
    private ReadDao readDao;
    private WriteDao writeDao;
    private final String inputPath = "src/main/java/db/input.csv";
    private final String destinationPath = "src/main/java/db/report.csv";

    public void run() {
        initialize();
        List<Record> records = readDao.read();
        Map<String, Integer> fruitMap = fruitService.processRecords(records);
        writeDao.save(fruitMap);
    }

    private void initialize() {
        parser = createParser();
        readDao = createReadDao();
        writeDao = createWriteDao();
        fruitService = createFruitService();
    }

    private Parser createParser() {
        return new CsvParser();
    }

    private ReadDao createReadDao() {
        return new CsvReadDaoImpl(inputPath, parser);
    }

    private WriteDao createWriteDao() {
        return new CsvWriteDaoImpl(destinationPath, parser);
    }

    private FruitService createFruitService() {
        return new FruitServiceImpl();
    }
}
