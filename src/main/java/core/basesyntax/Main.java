package core.basesyntax;

import core.basesyntax.dao.FileReadService;
import core.basesyntax.dao.FileReadServiceImpl;
import core.basesyntax.dao.Storage;
import core.basesyntax.dao.WriteDataToFile;
import core.basesyntax.dao.WriteDataToFileImpl;
import core.basesyntax.service.counter.BalanceTypeImpl;
import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.counter.PurchaseTypeImpl;
import core.basesyntax.service.counter.ReturnTypeImpl;
import core.basesyntax.service.counter.SupplyTypeImpl;
import core.basesyntax.service.report.CreateReport;
import core.basesyntax.service.report.CreateReportImpl;
import core.basesyntax.service.report.ReportService;
import core.basesyntax.service.report.ReportServiceImpl;
import core.basesyntax.service.transaction.FruitTransaction;
import core.basesyntax.service.transaction.TransactionParser;
import core.basesyntax.service.transaction.TransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String REPORT_FILE = "src/main/resources/Report.csv";

    public static void main(String[] args) {

        Map<String, OperationType> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceTypeImpl());
        operationStrategyMap.put("s", new SupplyTypeImpl());
        operationStrategyMap.put("p", new PurchaseTypeImpl());
        operationStrategyMap.put("r", new ReturnTypeImpl());

        FileReadService readService = new FileReadServiceImpl();
        List<String> dataFromReport = readService.getDataFromReport(REPORT_FILE);

        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransaction =
                transactionParser.getFruitTransaction(dataFromReport);

        ReportService resultFromReport = new ReportServiceImpl();
        resultFromReport.countFruit(fruitTransaction,
                Storage.getFruitTypesAndQuantity(), operationStrategyMap);

        CreateReport createReport = new CreateReportImpl();
        String dataForReport = createReport.getDataForReport(Storage.getFruitTypesAndQuantity());

        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeDataToFile(dataForReport);
    }
}
