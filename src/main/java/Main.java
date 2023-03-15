import handler.BalanceOperationHandler;
import handler.OperationHandler;
import handler.PurchaseOperationHandler;
import handler.ReturnOperationHandler;
import handler.SupplyOperationHandler;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.Parser;
import service.ReaderData;
import service.ReportData;
import service.TransactionHandler;
import service.WriterData;
import service.impl.CsvFileParserImpl;
import service.impl.CsvFileReaderService;
import service.impl.CsvFileWriterService;
import service.impl.ReportDataImpl;
import service.impl.TransactionHandlerImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;

public class Main {
    private static final String inputFile = "src/main/resources/InputData.csv";
    private static final String outputFile = "src/main/resources/OutputData.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        handlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());

        ReaderData readerData = new CsvFileReaderService();
        Parser parser = new CsvFileParserImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(operationStrategy);
        ReportData reportData = new ReportDataImpl();

        List<String> dataFromFile = readerData.read(Path.of(inputFile));
        List<FruitTransaction> parseData = parser.parse(dataFromFile);
        transactionHandler.parse(parseData);
        String creatReport = reportData.creatReport();
        WriterData writerData = new CsvFileWriterService();
        writerData.write(creatReport, outputFile);
    }
}
