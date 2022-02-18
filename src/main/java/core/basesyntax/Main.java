package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.ReportWriterDao;
import core.basesyntax.dao.impl.CsvReaderImpl;
import core.basesyntax.dao.impl.ReportSupplierDaoImpl;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.DataProcessorImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.impl.BalanceOperationHandler;
import core.basesyntax.service.strategy.impl.OperationStrategyImpl;
import core.basesyntax.service.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.service.strategy.impl.ReturnOperationHandler;
import core.basesyntax.service.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        HashMap<DataProcessorImpl.OperationType, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(DataProcessorImpl.OperationType.BALANCE, new BalanceOperationHandler());
        strategyMap.put(DataProcessorImpl.OperationType.SUPPLY, new SupplyOperationHandler());
        strategyMap.put(DataProcessorImpl.OperationType.PURCHASE, new PurchaseOperationHandler());
        strategyMap.put(DataProcessorImpl.OperationType.RETURN, new ReturnOperationHandler());

        final FileReader inputDao = new CsvReaderImpl();
        final ReportWriterDao reportSupplier = new ReportSupplierDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        final DataProcessor dataHandler = new DataProcessorImpl(operationStrategy);
        List<String> parsedDataFromFile = inputDao.parse("input.csv");
        dataHandler.createFruits(parsedDataFromFile);
        reportSupplier.createReport();
    }
}
