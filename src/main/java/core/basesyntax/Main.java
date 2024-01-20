package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.service.impl.FruitTransactionImpl;
import core.basesyntax.service.impl.OperationReport;
import core.basesyntax.service.impl.OperationReportImp;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.OperationStrategyImpl;
import java.util.List;

public class Main {
    private static OperationStrategy operationStrategy = new OperationStrategyImpl();

    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();
        FruitTransaction fruitTransaction = new FruitTransactionImpl(fruitDao, operationStrategy);

        System.out.println("\n");
        fruitTransaction.balance("banana", 20);
        fruitTransaction.balance("apple", 100);
        fruitTransaction.supply("banana", 100);
        fruitTransaction.purchase("banana", 13);
        fruitTransaction.returnFruits("apple", 10);
        fruitTransaction.purchase("apple", 20);
        fruitTransaction.purchase("banana", 5);
        fruitTransaction.supply("banana", 50);

        List<String> currentBalance = fruitDao.getCsv();
        System.out.println("Current Balance:");
        for (String line : currentBalance) {
            System.out.println(line);
        }

        System.out.println("\n");

        OperationReport operationReport = new OperationReportImp(fruitDao);
        operationReport.report();

        List<String> currentReport = fruitDao.getReportCsv();
        System.out.println("Current Report:");
        for (String line : currentReport) {
            System.out.println(line);
        }
    }
}
