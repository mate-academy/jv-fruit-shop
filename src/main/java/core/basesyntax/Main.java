package core.basesyntax;

import core.basesyntax.dao.ReportDao;
import core.basesyntax.dao.ReportDaoCsvImpl;
import core.basesyntax.dao.StorageDaoCsvImpl;
import core.basesyntax.operation.StoreOperation;
import core.basesyntax.service.BalanceQuantityCounter;
import core.basesyntax.service.OperationListProcessor;
import core.basesyntax.service.OperationListProcessorImpl;
import core.basesyntax.service.OperationListProvider;
import core.basesyntax.service.OperationListProviderImpl;
import core.basesyntax.service.PurchaseQuantityCounter;
import core.basesyntax.service.QuantityCounter;
import core.basesyntax.service.ReturnQuantityCounter;
import core.basesyntax.service.SupplyQuantityCounter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String STORAGE_FILE_PATH = "src/main/resources/storage.csv";
    private static final String REPORT_FILE_PATH = "src/main/resources/report.csv";
    private static Map<StoreOperation.Operation, QuantityCounter> quantityCounterMap
                                                                    = new HashMap<>();

    public static void main(String[] args) {
        quantityCounterMap.put(StoreOperation.Operation.BALANCE, new BalanceQuantityCounter());
        quantityCounterMap.put(StoreOperation.Operation.SUPPLY, new SupplyQuantityCounter());
        quantityCounterMap.put(StoreOperation.Operation.PURCHASE, new PurchaseQuantityCounter());
        quantityCounterMap.put(StoreOperation.Operation.RETURN, new ReturnQuantityCounter());
        StorageDaoCsvImpl storage = new StorageDaoCsvImpl();
        List<String> fileInfo = storage.get(STORAGE_FILE_PATH);
        OperationListProvider provider = new OperationListProviderImpl();
        List<StoreOperation> operations = provider.get(fileInfo);
        OperationListProcessor processor = new OperationListProcessorImpl();
        Map<String, Integer> endOfDayQuantities = processor.process(operations);
        ReportDao reportWriter = new ReportDaoCsvImpl();
        reportWriter.writeReport(endOfDayQuantities, REPORT_FILE_PATH);
    }

    public static Map<StoreOperation.Operation, QuantityCounter> get() {
        return quantityCounterMap;
    }
}
