import db.Storage;
import dto.FruitTransactionDto;
import java.util.List;
import java.util.Map;
import model.Fruit;
import service.DataParser;
import service.impl.CsvFruitDataReaderService;
import service.impl.FruitDataParser;
import service.operations.OperationHandler;
import service.operations.impl.BalanceOperationHandler;
import service.operations.impl.PurchaseOperationHandler;
import service.operations.impl.ReturnOperationHandler;
import service.operations.impl.SupplyOperationHandler;
import service.operations.report.ReportGenerator;
import service.operations.report.ReportWriter;
import strategy.Operation;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String reportPath = "src/main/java/resources/report.csv";
    private static final String inputPath = "src/main/java/resources/input";

    public static void main(String[] args) {
        Storage storage = new Storage();
        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler(storage);
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler(storage);
        ReturnOperationHandler returnOperationHandler = new ReturnOperationHandler(storage);
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler(storage);

        Map<Operation, OperationHandler> handlersMap = Map.of(
                Operation.BALANCE, balanceOperationHandler,
                Operation.PURCHASE, purchaseOperationHandler,
                Operation.RETURN, returnOperationHandler,
                Operation.SUPPLY, supplyOperationHandler
        );
        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(handlersMap);

        DataParser<FruitTransactionDto> fruitDataParser = new FruitDataParser();
        var readerService = new CsvFruitDataReaderService(fruitDataParser);
        List<FruitTransactionDto> dtos = readerService.read(inputPath);

        for (FruitTransactionDto dto : dtos) {
            operationStrategy.get(dto).apply(dto);
        }

        Map<Fruit, Integer> storageData = storage.getFruits();
        String reportContent = ReportGenerator.generateReportContent(storageData);
        ReportWriter.writeReportToFile(reportContent, reportPath);
    }
}
