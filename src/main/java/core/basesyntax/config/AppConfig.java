package core.basesyntax.config;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.ShopService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import core.basesyntax.service.impl.ShopServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.impl.BalanceOperation;
import core.basesyntax.strategy.impl.PurchaseOperation;
import core.basesyntax.strategy.impl.ReturnOperation;
import core.basesyntax.strategy.impl.SupplyOperation;
import java.util.HashMap;
import java.util.Map;

public class AppConfig {
    public FileReader fileReader() {
        return new FileReaderImpl();
    }

    public DataConverter dataConverter() {
        return new DataConverterImpl();
    }

    public Map<FruitTransaction.Operation, OperationHandler> operationHandlers() {
        StorageService storageService = storageService();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperation(storageService));
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperation(storageService));
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperation(storageService));
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new ReturnOperation(storageService));
        return operationHandlers;
    }

    public ShopService shopService() {
        return new ShopServiceImpl(operationHandlers());
    }

    public ReportGenerator reportGenerator() {
        return new ReportGeneratorImpl();
    }

    public FileWriter fileWriter() {
        return new FileWriterImpl();
    }

    public StorageService storageService() {
        return new StorageServiceImpl();
    }
}
