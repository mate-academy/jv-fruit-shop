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
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private ReadDao readDao;
    private WriteDao writeDao;
    private ReadParser readParser;
    private WriteParser writeParser;
    private OperationStrategy strategy;
    private FruitService fruitService;
    private final String inputPath = "src/main/resources/input.csv";
    private final String destinationPath = "src/main/resources/report.csv";

    public void run() {
        initialize();
        List<String> rowsFromFile = readDao.read();
        List<Record> records = readParser.parseFileData(rowsFromFile);
        Map<String, Integer> fruitMap = fruitService.processRecords(records);
        String parsedFruitMap = writeParser.parseProcessedData(fruitMap);
        writeDao.save(parsedFruitMap);
    }

    private void initialize() {
        readParser = new CsvReadParserImpl();
        writeParser = new CsvWriteParserImpl();
        readDao = new CsvReadDaoImpl(inputPath);
        writeDao = new CsvWriteDaoImpl(destinationPath);
        strategy = new OperationStrategy(new HashMap<>());
        fruitService = new FruitServiceImpl(strategy);
    }
}
