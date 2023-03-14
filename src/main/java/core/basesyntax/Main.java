package core.basesyntax;

import core.basesyntax.dao.TransactionDao;
import core.basesyntax.dao.TransactionDaoCsvImpl;
import core.basesyntax.repository.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.TransactionStrategyImpl;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import core.basesyntax.strategy.TransactionStrategy;

import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> operationsMap = Map.of(
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(),
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        TransactionDao dao = new TransactionDaoCsvImpl();
        TransactionStrategy strategy = new TransactionStrategyImpl(operationsMap);
        FruitService fruitService = new FruitServiceImpl(dao, strategy);
        List<FruitTransaction> transactions = fruitService.get("database.csv");
        System.out.println(transactions);
        fruitService.update(transactions);
        System.out.println(FruitStorage.fruitsOnStock);
        WriterService reportWriter = new ReportWriterImpl();
        reportWriter.write("report.csv");


        //All services should be independent.
        // We shouldn’t have Strategy and call its methods in CsvFileReaderService,
        // or we shouldn’t have CsvFileWriterService and call its methods in the Strategy class.

//Make all services independent and call them in the right order in main() method
// step by step (the result of previous service method should be the input for next one)

        //db for holding Storage
        //model for holding models like Fruit (if necessary)
        //service for holding services, like Writer, Reader, and so on
        //service.impl for holding implementations of services
        //strategy for holding handlers for different operations (you are expected to apply Strategy pattern)
    }
}
