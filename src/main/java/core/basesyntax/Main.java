package core.basesyntax;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Mapper;
import core.basesyntax.service.Parser;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.Writer;
import core.basesyntax.service.impl.CsvParser;
import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionMapper;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.operation.BalanceInputOperation;
import core.basesyntax.service.operation.InputTransaction;
import core.basesyntax.service.operation.PurchaseInputOperation;
import core.basesyntax.service.operation.ReturnInputOperation;
import core.basesyntax.service.operation.SupplyInputOperation;
import core.basesyntax.strategy.InputOperationStrategyImpl;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_INPUT_FILE = "src/main/resources/input.csv";
    private static final String PATH_TO_REPORT_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        FruitTransactionDao fruitTransactionDao = new FruitTransactionDaoImpl();
        Mapper<FruitTransaction> fruitTransactionMapper = new FruitTransactionMapper();
        Map<FruitTransaction.Operation, InputTransaction> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceInputOperation(fruitTransactionDao));
        strategyMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyInputOperation(fruitTransactionDao));
        strategyMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseInputOperation(fruitTransactionDao));
        strategyMap.put(FruitTransaction.Operation.RETURN,
                new ReturnInputOperation(fruitTransactionDao));

        Reader csvReader = new CsvReader();
        List<String> rawData = csvReader.readFile(PATH_TO_INPUT_FILE);

        Parser csvParser = new CsvParser(fruitTransactionMapper);
        List<FruitTransaction> fruitTransactions = csvParser.parseData(rawData);

        OperationStrategy operationStrategy = new InputOperationStrategyImpl(strategyMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.processTransactions(fruitTransactions);

        ReportService reportService = new ReportServiceImpl(fruitTransactionDao);
        String report = reportService.makeReport();

        Writer csvWriter = new CsvWriter();
        csvWriter.write(PATH_TO_REPORT_FILE,report);
    }
}
