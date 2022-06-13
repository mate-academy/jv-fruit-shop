package mate.academy;


import mate.academy.model.FruitTransaction;
import mate.academy.service.*;
import mate.academy.service.calculation.*;
import mate.academy.service.calculation.TransactionCalculation;
import mate.academy.service.impl.CreateReportImpl;
import mate.academy.service.impl.ParseFileImpl;
import mate.academy.service.impl.TransactionStrategyImpl;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<FruitTransaction.Operation, TransactionCalculation> transactionCalculationMap = new HashMap<>();
        transactionCalculationMap.put(FruitTransaction.Operation.BALANCE, new TransactionBalance());
        transactionCalculationMap.put(FruitTransaction.Operation.SUPPLY, new TransactionSupply());
        transactionCalculationMap.put(FruitTransaction.Operation.PURCHASE, new TransactionPurchase());
        transactionCalculationMap.put(FruitTransaction.Operation.RETURN, new TransactionReturn());

        TransactionStrategyImpl strategy = new TransactionStrategyImpl(transactionCalculationMap);
        ParseFile parseFile = new ParseFileImpl();

        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            strategy.get(operation).calculate(parseFile);
        }
        CreateReport createReport = new CreateReportImpl();
        createReport.createReport();

    }
}
