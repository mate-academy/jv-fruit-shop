package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dao.FruitOperationDao;
import core.basesyntax.dao.FruitOperationDaoImpl;
import core.basesyntax.model.FruitOperation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.FruitOperationMapper;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.operation.BalanceInputOperation;
import core.basesyntax.service.operation.InputOperation;
import core.basesyntax.service.operation.PurchaseInputOperation;
import core.basesyntax.service.operation.ReturnInputOperation;
import core.basesyntax.service.operation.SupplyInputOperation;
import core.basesyntax.strategy.InputOperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitOperationDao fruitOperationDao = new FruitOperationDaoImpl();
        Map<FruitOperation.Operation, InputOperation> map = new HashMap<>();
        map.put(FruitOperation.Operation.BALANCE, new BalanceInputOperation(fruitDao));
        map.put(FruitOperation.Operation.SUPPLY, new SupplyInputOperation(fruitDao));
        map.put(FruitOperation.Operation.RETURN, new ReturnInputOperation(fruitDao));
        map.put(FruitOperation.Operation.PURCHASE, new PurchaseInputOperation(fruitDao));
        Reader csvReader = new CsvReader();
        List<String> readedData = csvReader.readFile(PATH_TO_INPUT_FILE);
        Parser csvParser = new CsvParser();
        List<String[]> parsedData = csvParser.parseData(readedData);
        Mapper<FruitOperation> fruitOperationMapper = new FruitOperationMapper();
        for (String[] parsedRow : parsedData) {
            FruitOperation fruitOperation = fruitOperationMapper.getMappedObject(parsedRow);
            fruitOperationDao.add(fruitOperation);
        }
        FruitService fruitService = new FruitServiceImpl(new InputOperationStrategyImpl(map),
                fruitOperationDao);
        fruitService.processOperations();
        ReportService reportService = new ReportServiceImpl(fruitDao);
        StringBuilder stringBuilder = reportService.makeReport();
        Writer csvWriter = new CsvWriter();
        csvWriter.write(PATH_TO_REPORT_FILE, stringBuilder.toString());
    }
}
