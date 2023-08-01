package core.basesyntax;

import core.basesyntax.handlers.BalanceHandler;
import core.basesyntax.handlers.OperationHandler;
import core.basesyntax.handlers.PurchaseHandler;
import core.basesyntax.handlers.ReturnHandler;
import core.basesyntax.handlers.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.TransactionExecutor;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.implemantation.CsvFileReaderImpl;
import core.basesyntax.service.implemantation.ReportGeneratorImpl;
import core.basesyntax.service.implemantation.DataParserImpl;
import core.basesyntax.service.implemantation.TransactionExecutorImpl;
import core.basesyntax.service.implemantation.ReportWriterImpl;
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

    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReaderImpl();
        List<String> data = fileReader.readDate("src/main/resources/input.csv");
        DataParser parseData = new DataParserImpl();
        List<FruitTransaction> fruitTransactions = parseData.parse(data);
        TransactionExecutor processData = new TransactionExecutorImpl();
        processData.processDate(fruitTransactions, operationHandlerMap);
        ReportGenerator generateReport = new ReportGeneratorImpl();
        String report = generateReport.generateReport();
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.writeReport(report, "src/main/resources/report");

    }

}
