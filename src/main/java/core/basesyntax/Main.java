package core.basesyntax;

import core.basesyntax.model.FruitRecord;
import core.basesyntax.operation.Operation;
import core.basesyntax.operation.OperationBalance;
import core.basesyntax.operation.OperationPurchase;
import core.basesyntax.operation.OperationReturn;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.OperationSupply;
import core.basesyntax.operation.OperationType;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataParserImpl;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReaderServiceImpl;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportCreatorImpl;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    public static void main(String[] args) {
        Map<OperationType, Operation> operationMap = new HashMap<>();
        operationMap.put(OperationType.BALANCE, new OperationBalance());
        operationMap.put(OperationType.PURCHASE, new OperationPurchase());
        operationMap.put(OperationType.RETURN, new OperationReturn());
        operationMap.put(OperationType.SUPPLY, new OperationSupply());
        OperationStrategy strategy = new OperationStrategyImpl(operationMap);
        DataParser parser = new DataParserImpl(strategy);
        ReportCreator creator = new ReportCreatorImpl();
        ReaderService readerService = new ReaderServiceImpl();
        LocalDate date = LocalDate.now();
        String fromPath = "src/main/resources/inputFile.csv";
        String toPath = "src/main/resources/dayReport.csv";
        List<FruitRecord> records = readerService.read(fromPath);
        parser.parseAndAddToStorage(records);
        creator.createReport(toPath, date);
        System.out.println("Your report wait you in src/main/resources, name as: outputFile.csv");
    }
}
