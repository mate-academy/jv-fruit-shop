package core.basesyntax;

import core.basesyntax.dao.FileReadService;
import core.basesyntax.dao.FileReadServiceImpl;
import core.basesyntax.dao.Storage;
import core.basesyntax.dao.WriteDataToFile;
import core.basesyntax.dao.WriteDataToFileImpl;
import core.basesyntax.service.counter.BalanceHandlerImpl;
import core.basesyntax.service.counter.OperationHandler;
import core.basesyntax.service.counter.PurchaseHandlerImpl;
import core.basesyntax.service.counter.ReturnHandlerImpl;
import core.basesyntax.service.counter.SupplyHandlerImpl;
import core.basesyntax.service.report.ReportCreator;
import core.basesyntax.service.report.ReportCreatorImpl;
import core.basesyntax.service.report.TransactionProcessor;
import core.basesyntax.service.report.TransactionProcessorImpl;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.transaction.FruitTransaction;
import core.basesyntax.service.transaction.TransactionParser;
import core.basesyntax.service.transaction.TransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT_FILE = "src/main/resources/Report.csv";

    public static void main(String[] args) {

        Map<String, OperationHandler> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceHandlerImpl());
        operationStrategyMap.put("s", new SupplyHandlerImpl());
        operationStrategyMap.put("p", new PurchaseHandlerImpl());
        operationStrategyMap.put("r", new ReturnHandlerImpl());

        FileReadService readService = new FileReadServiceImpl();
        List<String> dataFromReport = readService.getDataFromReport(REPORT_FILE);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransaction =
                transactionParser.getFruitTransaction(dataFromReport);

        TransactionProcessor resultFromReport =
                new TransactionProcessorImpl(new OperationStrategyImpl(operationStrategyMap));
        resultFromReport.process(fruitTransaction);

        ReportCreator createReport = new ReportCreatorImpl();
        String dataForReport = createReport.getDataForReport(Storage.getFruitTypesAndQuantity());

        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeDataToFile(dataForReport);
    }
}
