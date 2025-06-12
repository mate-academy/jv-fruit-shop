import core.basesyntax.dao.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataConverterImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ReaderFromCsv;
import core.basesyntax.service.ReaderFromCsvImpl;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportGeneratorImpl;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.ShopServiceImpl;
import core.basesyntax.service.WriterReportToCsv;
import core.basesyntax.service.WriterReportToCsvImpl;
import core.basesyntax.service.operations.BalanceOperation;
import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.service.operations.PurchaseOperation;
import core.basesyntax.service.operations.ReturnOperation;
import core.basesyntax.service.operations.SupplyOperation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_TO_READ = "src/main/resources/reportToRead.csv";
    private static final String FILE_TO_WRITE = "src/main/resources/finalReport.csv";

    public static void main(String[] arg) {
        ReaderFromCsv fileReader = new ReaderFromCsvImpl();
        List<String> inputReport = fileReader.read(FILE_TO_READ);

        Map<Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(Operation.BALANCE, new BalanceOperation());
        operationHandlers.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlers.put(Operation.SUPPLY, new SupplyOperation());
        operationHandlers.put(Operation.RETURN, new ReturnOperation());

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlers);
        ShopService shopService = new ShopServiceImpl(operationStrategy);
        for (FruitTransaction transaction : transactions) {
            shopService.transfer(transaction);
        }

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.getReport(FruitStorage.storage);

        WriterReportToCsv fileWriter = new WriterReportToCsvImpl();
        fileWriter.writeReport(report, FILE_TO_WRITE);
    }
}
