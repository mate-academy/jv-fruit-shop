package core.basesyntax;

import core.basesyntax.dao.InputDao;
import core.basesyntax.dao.InputDaoImpl;
import core.basesyntax.dao.ReportSupplierDaoImpl;
import core.basesyntax.dao.ReportWriterDao;
import core.basesyntax.service.DataProcessor;
import core.basesyntax.service.DataProcessorImpl;
import core.basesyntax.service.strategy.BalanceOperationHandler;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.PurchaseOperationHandler;
import core.basesyntax.service.strategy.ReturnOperationHandler;
import core.basesyntax.service.strategy.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(final String[] args) {
        HashMap<DataProcessorImpl.OperationType, OperationHandler> strategyMap = new HashMap<>();
        strategyMap.put(DataProcessorImpl.OperationType.BALANCE, new BalanceOperationHandler());
        strategyMap.put(DataProcessorImpl.OperationType.SUPPLY, new SupplyOperationHandler());
        strategyMap.put(DataProcessorImpl.OperationType.PURCHASE, new PurchaseOperationHandler());
        strategyMap.put(DataProcessorImpl.OperationType.RETURN, new ReturnOperationHandler());

        final InputDao inputDao = new InputDaoImpl();
        final ReportWriterDao reportSupplier = new ReportSupplierDaoImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(strategyMap);
        final DataProcessor dataHandler = new DataProcessorImpl(operationStrategy);
        List<String> parsedDataFromFile = inputDao.parse("input.csv");
        dataHandler.createFruits(parsedDataFromFile);
        reportSupplier.createReport();
    }
}
