package core.basesyntax;

import impl.OperationStrategyImpl;
import impl.ParseServiceImpl;
import impl.ReadServiceImpl;
import impl.ReportServiceImpl;
import impl.TransactionServiceImpl;
import impl.WriteServiceImpl;
import java.util.HashMap;
import java.util.Map;
import model.FruitTransaction;
import service.OperationStrategy;
import service.ParseService;
import service.ReadService;
import service.ReportService;
import service.WriteService;
import strategy.BalanceHandler;
import strategy.OperationHandler;
import strategy.PurchaseHandler;
import strategy.ReturnHandler;
import strategy.SupplyHandler;

public class Main {

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        ReadService readService = new ReadServiceImpl();
        ParseService parseService = new ParseServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        WriteService writeService = new WriteServiceImpl();

        TransactionServiceImpl transactionService = new TransactionServiceImpl(operationStrategy,
                readService, parseService, reportService, writeService);
        transactionService.processTransactions();

    }
}
