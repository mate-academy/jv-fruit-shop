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

        Map<FruitTransaction.Operation, OperationStrategy> strategyMap
                = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceStrategy(),
                FruitTransaction.Operation.SUPPLY, new SupplyStrategy(),
                FruitTransaction.Operation.PURCHASE, new PurchaseStrategy(),
                FruitTransaction.Operation.RETURN, new ReturnStrategy()
        );

        ReaderService readerService = new ReaderServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        TransactionProcessorServiceImpl processorService =
                new TransactionProcessorServiceImpl(strategyMap);
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
}
