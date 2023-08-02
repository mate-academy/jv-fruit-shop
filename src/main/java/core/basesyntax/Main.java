package core.basesyntax;

import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.implemantation.CsvFileReaderImpl;
import core.basesyntax.service.implemantation.DataParserImpl;
import core.basesyntax.service.implemantation.ReportGeneratorImpl;
import core.basesyntax.service.implemantation.ReportWriterImpl;
import core.basesyntax.service.implemantation.TransactionExecutorImpl;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final Map<Operation, OperationHandler> operationHandlerMap = Map.of(
            Operation.BALANCE, new BalanceHandler(),
            Operation.SUPPLY, new SupplyHandler(),
            Operation.PURCHASE, new PurchaseHandler(),
            Operation.RETURN, new ReturnHandler());
    private static final String PATH_TO_READ = "src/main/resources/input.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/report";

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReaderImpl();
        List<String> data = fileReader.readData(PATH_TO_READ);
        DataParser parseData = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = parseData.parse(data);
        TransactionExecutor transactionExecutor = new TransactionExecutorImpl();
        transactionExecutor.processDate(fruitTransactions, operationHandlerMap);
        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        String report = reportGenerator.generateReport();
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(report, PATH_TO_WRITE);

    }

}
