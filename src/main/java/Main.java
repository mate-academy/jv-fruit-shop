import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.CsvFileReaderService;
import service.CsvFileWriterService;
import service.FruitService;
import service.FruitTransactionParser;
import service.ReportGenerator;
import service.impl.CsvFileReaderServiceImpl;
import service.impl.CsvFileWriterServiceImpl;
import service.impl.FruitServiceImpl;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReportGeneratorImpl;
import strategy.OperationHandler;
import strategy.handlers.BalanceHandler;
import strategy.handlers.PurchaseHandler;
import strategy.handlers.ReturnHandler;
import strategy.handlers.SupplyHandler;

public class Main {
    private static final int INPUT_FILE_PATH_ARG_INDEX = 0;
    private static final int OUTPUT_FILE_PATH_ARG_INDEX = 1;

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Please provide input and "
                    + "output file paths as arguments.");
        }

        String inputFilePath = args[INPUT_FILE_PATH_ARG_INDEX];
        String outputFilePath = args[OUTPUT_FILE_PATH_ARG_INDEX];

        CsvFileReaderService readerService = new CsvFileReaderServiceImpl();
        FruitTransactionParser parser = new FruitTransactionParserImpl();
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        CsvFileWriterService writerService = new CsvFileWriterServiceImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseHandler(),
                FruitTransaction.Operation.RETURN, new ReturnHandler()
        );

        FruitService fruitService = new FruitServiceImpl(operationHandlers);

        List<String> lines = readerService.readFromFile(inputFilePath);
        List<FruitTransaction> transactions = parser.parseLines(lines);

        fruitService.applyTransactions(transactions);

        List<String> report = reportGenerator.generateReport(fruitService.getReportData());
        writerService.writeToFile(outputFilePath, report);
    }
}
