package core.basesyntax;

import core.basesyntax.dao.ActivitiesDao;
import core.basesyntax.dao.ActivitiesDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConvertorService;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ConvertorServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.strategy.OperationBalancePerformer;
import core.basesyntax.strategy.OperationPerformer;
import core.basesyntax.strategy.OperationPurchasePerformer;
import core.basesyntax.strategy.OperationReturnPerformer;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import core.basesyntax.strategy.OperationSupplyPerformer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String RECORD_PATH = "src\\main\\resources\\infoRecord.csv";
    private static final String REPORT_PATH = "src\\main\\resources\\report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationPerformer> operationPerformerMap = new HashMap<>();
        operationPerformerMap.put(FruitTransaction.Operation.BALANCE,
                new OperationBalancePerformer());
        operationPerformerMap.put(FruitTransaction.Operation.PURCHASE,
                new OperationPurchasePerformer());
        operationPerformerMap.put(FruitTransaction.Operation.RETURN,
                new OperationReturnPerformer());
        operationPerformerMap.put(FruitTransaction.Operation.SUPPLY,
                new OperationSupplyPerformer());

        ConvertorService convertorService = new ConvertorServiceImpl();
        ReaderService readerService = new ReaderServiceImpl();
        ActivitiesDao activitiesDao = new ActivitiesDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationPerformerMap);
        ProcessService shopService = new ProcessServiceImpl(operationStrategy);
        ReportService reportService = new ReportServiceImpl();

        List<String> fileData = readerService.read(RECORD_PATH);
        List<FruitTransaction> fruitTransactions = convertorService.convertData(fileData);
        Storage storage = shopService.processObjects(fruitTransactions);
        String report = reportService.createReport(storage);
        activitiesDao.write(report, REPORT_PATH);
    }
}
