package core.basesyntax;

import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionCalculate;
import java.util.List;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        List<Transaction> transactionList = new ReaderServiceImpl().getListTransaction();
        List<Transaction> listTotalResult = new TransactionCalculate()
                .getTotalResult(transactionList);
        new WriterServiceImpl().writeFile(listTotalResult);
    }
}
