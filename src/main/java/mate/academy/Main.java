package mate.academy;

import java.util.HashMap;
import java.util.Map;
import mate.academy.model.FruitTransaction;
import mate.academy.service.CreateReport;
import mate.academy.service.ParseFile;
import mate.academy.service.calculation.TransactionBalance;
import mate.academy.service.calculation.TransactionCalculation;
import mate.academy.service.calculation.TransactionPurchase;
import mate.academy.service.calculation.TransactionReturn;
import mate.academy.service.calculation.TransactionSupply;
import mate.academy.service.impl.CreateReportImpl;
import mate.academy.service.impl.ParseFileImpl;
import mate.academy.service.impl.TransactionStrategyImpl;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionCalculation> strategyMap = new HashMap<>();
        strategyMap.put(FruitTransaction.Operation.BALANCE, new TransactionBalance());
        strategyMap.put(FruitTransaction.Operation.SUPPLY, new TransactionSupply());
        strategyMap.put(FruitTransaction.Operation.PURCHASE, new TransactionPurchase());
        strategyMap.put(FruitTransaction.Operation.RETURN, new TransactionReturn());

        TransactionStrategyImpl strategy = new TransactionStrategyImpl(strategyMap);
        ParseFile parseFile = new ParseFileImpl();

        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            strategy.get(operation).calculate(parseFile);
        }
        CreateReport createReport = new CreateReportImpl();
        createReport.createReport();

    }
}
