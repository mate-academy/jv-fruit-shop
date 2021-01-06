package core.basesyntax;

import core.basesyntax.model.Operation;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FruitFileWriter;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.Parser;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ParserCsvFile;
import core.basesyntax.strategy.BalanceStrategy;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.PurchaseStrategy;
import core.basesyntax.strategy.ReturnStrategy;
import core.basesyntax.strategy.SupplyStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Application {
    private static final String PATH_READ = "src/main/resources/fruitShop.csv";
    private static final String PATH_WRITE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationStrategy> operationOperationStrategyMap = new HashMap<>();
        operationOperationStrategyMap.put(Operation.BALANCE, new BalanceStrategy());
        operationOperationStrategyMap.put(Operation.SUPPLY, new SupplyStrategy());
        operationOperationStrategyMap.put(Operation.RETURN, new ReturnStrategy());
        operationOperationStrategyMap.put(Operation.PURCHASE, new PurchaseStrategy());

        FileReader reader = new CsvFileReader();
        Parser parser = new ParserCsvFile();
        List<TransactionDto> transactions = parser.parseCsvFile(reader.readData(PATH_READ));
        FruitService service = new FruitServiceImpl(operationOperationStrategyMap);
        service.applyOperation(transactions);

        FruitFileWriter writer = new CsvFileWriter();
        writer.writeToFile(service.getFruitReport(), PATH_WRITE);
    }
}
