import dao.FruitDaoImpl;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.DataConverter;
import service.ReaderService;
import service.ReportGenerator;
import service.ShopService;
import service.WriterService;
import service.impl.DataConverterImpl;
import service.impl.DataValidatorServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportGeneratorImpl;
import service.impl.ShopServiceImpl;
import service.impl.WriterServiceImpl;
import service.operation.BalanceOperation;
import service.operation.OperationHandler;
import service.operation.PurchaseOperation;
import service.operation.ReturnOperation;
import service.operation.SupplyOperation;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String FROM_FILE = "src/main/resources/reportToRead.csv";
    private static final String TO_FILE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        ReaderService fileReader = new ReaderServiceImpl();
        List<String> inputReport = fileReader.read(FROM_FILE);

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperation(new FruitDaoImpl()),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperation(new FruitDaoImpl()),
                FruitTransaction.Operation.RETURN, new ReturnOperation(new FruitDaoImpl()),
                FruitTransaction.Operation.SUPPLY, new SupplyOperation(new FruitDaoImpl()));
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);

        DataConverter dataConverter = new DataConverterImpl(new DataValidatorServiceImpl());
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        ShopService shopService = new ShopServiceImpl(operationStrategy);
        shopService.process(transactions);

        ReportGenerator reportGenerator = new ReportGeneratorImpl(new FruitDaoImpl());
        String resultingReport = reportGenerator.getReport();

        WriterService writerService = new WriterServiceImpl();
        writerService.write(resultingReport, TO_FILE);
    }
}
