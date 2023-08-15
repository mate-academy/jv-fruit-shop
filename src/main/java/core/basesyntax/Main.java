package core.basesyntax;

import core.basesyntax.dao.FileReadService;
import core.basesyntax.dao.FileReadServiceImpl;
import core.basesyntax.dao.WriteDataToFile;
import core.basesyntax.dao.WriteDataToFileImpl;
import core.basesyntax.service.counter.BalanceTypeImpl;
import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.counter.PurchaseTypeImpl;
import core.basesyntax.service.counter.ReturnTypeImpl;
import core.basesyntax.service.counter.SupplyTypeImpl;
import core.basesyntax.service.result.ResultFromReport;
import core.basesyntax.service.result.ResultFromReportImpl;
import core.basesyntax.service.transaction.TransactionParser;
import core.basesyntax.service.transaction.TransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_PATH = "src/main/resources/Report.csv";

    public static void main(String[] args) {

        Map<String, OperationType> operationStrategyMap = new HashMap<>();
        operationStrategyMap.put("b", new BalanceTypeImpl());
        operationStrategyMap.put("s", new SupplyTypeImpl());
        operationStrategyMap.put("p", new PurchaseTypeImpl());
        operationStrategyMap.put("r", new ReturnTypeImpl());
        
        Map<String, Integer> fruitTypesAndQuantity = new HashMap<>();

        FileReadService readService = new FileReadServiceImpl();
        List<String> dataFromReport = readService.getDataFromReport(FILE_PATH);

        ResultFromReport resultFromReport = new ResultFromReportImpl();
        TransactionParser transactionParser = new TransactionParserImpl();
        resultFromReport.getResultFromReport(transactionParser.getFruitTransaction(dataFromReport),
                fruitTypesAndQuantity, operationStrategyMap);

        WriteDataToFile writeDataToFile = new WriteDataToFileImpl();
        writeDataToFile.writeDataToFile(fruitTypesAndQuantity);
    }

}
