package core.basesyntax.application;

import core.basesyntax.dao.ReadDao;
import core.basesyntax.dao.WriteDao;
import core.basesyntax.dao.impl.CsvReadDaoImpl;
import core.basesyntax.dao.impl.CsvWriteDaoImpl;
import core.basesyntax.model.fruit.Record;
import core.basesyntax.service.fruit.FruitService;
import core.basesyntax.service.fruit.impl.FruitServiceImpl;
import core.basesyntax.service.parser.ReadParser;
import core.basesyntax.service.parser.WriteParser;
import core.basesyntax.service.parser.impl.CsvReadParserImpl;
import core.basesyntax.service.parser.impl.CsvWriteParserImpl;
import java.util.List;
import java.util.Map;

public class Application {
    private ReadDao readDao;
    private WriteDao writeDao;
    private ReadParser readParser;
    private WriteParser writeParser;
    private FruitService fruitService;
    private final String inputPath = "src/main/resources/input.csv";
    private final String destinationPath = "src/main/resources/report.csv";

    public void run() {
        initialize();
        List<Record> records = readDao.read();
        Map<String, Integer> fruitMap = fruitService.processRecords(records);
        writeDao.save(fruitMap);
    }

    private void initialize() {
        readParser = createReadParser();
        writeParser = createWriteParser();
        readDao = createReadDao();
        writeDao = createWriteDao();
        fruitService = createFruitService();
    }

    private ReadParser createReadParser() {
        return new CsvReadParserImpl();
    }

    private WriteParser createWriteParser() {
        return new CsvWriteParserImpl();
    }

    private ReadDao createReadDao() {
        return new CsvReadDaoImpl(inputPath, readParser);
    }

    private WriteDao createWriteDao() {
        return new CsvWriteDaoImpl(destinationPath, writeParser);
    }

    private FruitService createFruitService() {
        return new FruitServiceImpl();
    }
}
