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
import strategy.OperationStrategy;

public class Main {
    public static void main(String[] args) {
        Storage storage = new Storage();
        BalanceOperationHandler balanceOperationHandler = new BalanceOperationHandler(storage);
        PurchaseOperationHandler purchaseOperationHandler = new PurchaseOperationHandler(storage);
        ReturnOperationHandler returnOperationHandler = new ReturnOperationHandler(storage);
        SupplyOperationHandler supplyOperationHandler = new SupplyOperationHandler(storage);
        List<OperationHandler> handlers = List.of(balanceOperationHandler,
                purchaseOperationHandler,
                returnOperationHandler,
                supplyOperationHandler);
        OperationStrategy operationStrategy = new OperationStrategy(handlers);

        DataParser<FruitTransactionDto> fruitDataParser = new FruitDataParser();
        var readerService = new CsvFruitDataReaderService(fruitDataParser);
        List<FruitTransactionDto> dtos = readerService.read("src/main/java/resources/input");

        for (var dto : dtos) {
            operationStrategy.getHandlers(dto).forEach(oh -> oh.apply(dto));
        }

        Map<Fruit, Integer> storageData = storage.getFruits();
        String reportContent = ReportGenerator.generateReportContent(storageData);
        ReportWriter.writeReportToFile(reportContent, "src/main/java/resources/report.csv");
    }
}
