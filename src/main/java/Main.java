import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.ParseService;
import service.ReaderService;
import service.ReportService;
import service.WriterService;
import service.impl.ParseServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
import service.impl.TransactionProcessorServiceImpl;
import service.impl.WriterServiceImpl;
import strategy.BalanceStrategy;
import strategy.OperationStrategy;
import strategy.PurchaseStrategy;
import strategy.ReturnStrategy;
import strategy.SupplyStrategy;

public class Main {
    public static void main(String[] args) {
        final String input_File_Path = "src/main/resources/fruitList.csv";
        final String output_File_Path = "src/main/resources/output.csv";

        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        TransactionProcessorServiceImpl processorService =
                new TransactionProcessorServiceImpl(buildStrategyMap());
        ReportService reportService = new ReportServiceImpl();
        WriterService writerService = new WriterServiceImpl();

        List<String> fileContent =
                readerService.readFromFilesContents(input_File_Path);

        List<FruitTransaction> parsedFromString =
                parseService.parseFromString(fileContent);

        Map<String, Integer> fruitCounts = processorService.processTransaction(parsedFromString);

        List<String> report = reportService.generateReport(fruitCounts);

        writerService.writeToFile(output_File_Path, report);
    }

    private static Map<FruitTransaction.Operation, OperationStrategy> buildStrategyMap() {
        Map<FruitTransaction.Operation, OperationStrategy> operationStrategies = new HashMap<>();
        operationStrategies.put(FruitTransaction.Operation.BALANCE, new BalanceStrategy());
        operationStrategies.put(FruitTransaction.Operation.SUPPLY, new SupplyStrategy());
        operationStrategies.put(FruitTransaction.Operation.PURCHASE, new PurchaseStrategy());
        operationStrategies.put(FruitTransaction.Operation.RETURN, new ReturnStrategy());
        return operationStrategies;
    }
}
