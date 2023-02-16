package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.BalanceTransactionRecord;
import core.basesyntax.service.impl.PurchaseTransactionRecord;
import core.basesyntax.service.impl.ReturnTransactionRecord;
import core.basesyntax.service.impl.ShiftReport;
import core.basesyntax.service.impl.ShiftReportImpl;
import core.basesyntax.service.impl.SupplyTransactionRecord;
import core.basesyntax.service.impl.TransactionRecord;

public class Main {
    public static void main(String[] args) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setFruit("orange");
        fruitTransaction.setQuantity(15);
        TransactionRecord balanceTransactionRecord = new BalanceTransactionRecord();
        balanceTransactionRecord.addTransaction(fruitTransaction);
        TransactionRecord purchaseTransactionRecord = new PurchaseTransactionRecord();
        fruitTransaction.setFruit("apple");
        fruitTransaction.setQuantity(20);
        purchaseTransactionRecord.addTransaction(fruitTransaction);
        TransactionRecord returnTransactionRecord = new ReturnTransactionRecord();
        fruitTransaction.setFruit("orange");
        fruitTransaction.setQuantity(40);
        returnTransactionRecord.addTransaction(fruitTransaction);
        TransactionRecord supplyTransactionRecord = new SupplyTransactionRecord();
        fruitTransaction.setFruit("orange");
        fruitTransaction.setQuantity(50);
        ShiftReport shiftReport = new ShiftReportImpl();
        supplyTransactionRecord.addTransaction(fruitTransaction);
        shiftReport.addReport();
    }
}
