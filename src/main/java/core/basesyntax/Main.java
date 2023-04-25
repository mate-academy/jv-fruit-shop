package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.*;
import core.basesyntax.service.operation.*;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImp;

import java.util.HashMap;
import java.util.Map;


public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperation());
        operationMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperation());
        operationMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperation());
        operationMap.put(FruitTransaction.Operation.RETURN, new ReturnOperation());
        OperationStrategy operationStrategy = new OperationStrategyImp(operationMap);
        ReadScvService readScvService = new ReadScvServiceImpl();
        FruitTransferImpl fruitTransfer = new FruitTransferImpl(operationStrategy, readScvService);
        fruitTransfer.transfer();
        ReportService report = new ReportServiceImpl();
        report.createReport();

    }
}
