package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.CsvParserImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.strategies.BalanceStrategy;
import core.basesyntax.strategy.strategies.PurchaseStrategy;
import core.basesyntax.strategy.strategies.ReturnStrategy;
import core.basesyntax.strategy.strategies.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {
    private static final String FILE_FROM = "src/main/resources/shop_activity.csv";
    private static final String FILE_TO = "src/main/resources/report.csv";
    private static Map<Operation, OperationStrategy> operationStrategyMap = new HashMap<>();

    public static void main(String[] args) {
        operationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());
        operationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());

        CsvFileReader reader = new CsvFileReaderImpl();
        List<String> dataFromFile = reader.readFromFile(FILE_FROM);
        List<TransactionDto> parsedData = new CsvParserImpl().parse(dataFromFile);

        FruitService service = new FruitServiceImpl(operationStrategyMap);
        service.processActivities(parsedData);

        CsvFileWriter writer = new CsvFileWriterImpl();
        writer.writeToFile(FILE_TO, service.getReport());
    }
}
