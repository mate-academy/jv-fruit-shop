import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.ReaderService;
import service.ReportGenerator;
import service.ShopService;
import service.WriterService;
import service.impl.DataConverterImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceOperation;
import strategy.OperationHandler;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        List<String> lines = reader.readFromFile("src/main/resources/reportToRead.csv");

        DataConverter converter = new DataConverterImpl();
        List<FruitTransaction> transactions = converter.convertToTransactions(lines);

        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperation());

        OperationStrategy strategy = new OperationStrategyImpl(handlers);
        ShopService shopService = new ShopServiceImpl(strategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport();

        WriterService writer = new WriterServiceImpl();
        writer.writeToFile(report, "src/main/resources/finalReport.csv");
    }
}
