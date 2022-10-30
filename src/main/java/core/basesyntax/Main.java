package core.basesyntax;

import core.basesyntax.filework.ReportWriteToFile;
import core.basesyntax.filework.ShopFileReader;
import core.basesyntax.filework.impl.ReportWriteToFileImpl;
import core.basesyntax.filework.impl.ShopFileReaderImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitTransactionData;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.Report;
import core.basesyntax.service.impl.BalanceService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.FruitTransactionDataImpl;
import core.basesyntax.service.impl.PurchaseService;
import core.basesyntax.service.impl.ReportImpl;
import core.basesyntax.service.impl.ReturnService;
import core.basesyntax.service.impl.SupplyService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static final String INPUT_FILE_PATH = "src/main/resources/fruitShopStoreFile.csv";

    public static void main(String[] args) {
        Map<Operation, OperationService> operationServiceMap = new HashMap<>();
        operationServiceMap.put(Operation.BALANCE, new BalanceService());
        operationServiceMap.put(Operation.SUPPLY, new SupplyService());
        operationServiceMap.put(Operation.RETURN, new ReturnService());
        operationServiceMap.put(Operation.PURCHASE, new PurchaseService());

        ShopFileReader shopFileReader = new ShopFileReaderImpl();
        List<String> listReadFile = shopFileReader.readFromFile(INPUT_FILE_PATH);

        FruitTransactionData fruitTransactionData = new FruitTransactionDataImpl();
        List<FruitTransaction> fruitTransactions
                = fruitTransactionData.createFruitTransactionEqualFile(listReadFile);

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationServiceMap);
        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.doOperationService(fruitTransactions);

        Report report = new ReportImpl();
        String report1 = report.makeReport();
        ReportWriteToFile reportWriteToFile = new ReportWriteToFileImpl();
        reportWriteToFile.writeReportToFile(report1);
    }
}
