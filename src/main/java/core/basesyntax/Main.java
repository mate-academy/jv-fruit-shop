package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.dto.FruitTransactionDto;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.CsvFruitDataReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitDataParser;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import core.basesyntax.service.impl.strategy.BalanceOperation;
import core.basesyntax.service.impl.strategy.PurchaseOperation;
import core.basesyntax.service.impl.strategy.ReturnOperation;
import core.basesyntax.service.impl.strategy.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fileFrom = "src\\resources\\file.csv";
    private static final String fileTo = "src\\resources\\report.csv";
    private static final FruitDataParser parser = new FruitDataParser();
    private static final CsvFruitDataReaderImpl dataReader = new CsvFruitDataReaderImpl();
    private static final ReportGenerator reportGenerator = new ReportGeneratorImpl();
    private static final FileWriterService fileWriterService = new FileWriterImpl();

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operations = initializeStrategy();
        StrategyServiceImpl service = new StrategyServiceImpl(operations);
        List<String> rawData = dataReader.readData(fileFrom);
        List<FruitTransactionDto> parsedData = parser.parse(rawData);
        service.processData(parsedData, operations);
        List<String> report = reportGenerator.createReport();
        fileWriterService.write(report, fileTo);

        System.out.println(report);
        System.out.println(Storage.fruitStorage);
    }

    private static Map<Operation, OperationHandler> initializeStrategy() {
        return Map.of(
                Operation.BALANCE, new BalanceOperation(),
                Operation.RETURN, new ReturnOperation(),
                Operation.PURCHASE, new PurchaseOperation(),
                Operation.SUPPLY, new SupplyOperation()
        );
    }
}
