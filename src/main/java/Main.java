import dao.FruitDaoImpl;
import dao.FruitsDao;
import db.Storage;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitTransactionParserService;
import service.ReaderData;
import service.ReportData;
import service.TransactionHandler;
import service.WriterData;
import service.impl.CsvFileReaderService;
import service.impl.CsvFileWriterService;
import service.impl.FruitTransactionParserImpl;
import service.impl.ReportDataImpl;
import service.impl.TransactionHandlerImpl;
import strategy.OperationStrategy;
import strategy.OperationStrategyImpl;
import strategy.handler.BalanceOperationHandler;
import strategy.handler.OperationHandler;
import strategy.handler.PurchaseOperationHandler;
import strategy.handler.ReturnOperationHandler;
import strategy.handler.SupplyOperationHandler;

public class Main {
    private static final String inputFile = "src/main/resources/InputData.csv";
    private static final String outputFile = "src/main/resources/OutputData.csv";

    public static void main(String[] args) {
        FruitsDao fruitsDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, OperationHandler> handlerMap = new HashMap<>();
        handlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitsDao));
        handlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitsDao));
        handlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitsDao));
        handlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitsDao));

        ReaderData readerData = new CsvFileReaderService();
        FruitTransactionParserService parser = new FruitTransactionParserImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(handlerMap);
        TransactionHandler transactionHandler = new TransactionHandlerImpl(operationStrategy);
        ReportData reportData = new ReportDataImpl();

        List<String> dataFromFile = readerData.read(Path.of(inputFile));
        List<FruitTransaction> parseData = parser.parse(dataFromFile);
        transactionHandler.proccesFruitTransaction(parseData);
        String creatReport = reportData.creatReport(Storage.fruits);
        WriterData writerData = new CsvFileWriterService();
        writerData.write(creatReport, outputFile);
    }
}
