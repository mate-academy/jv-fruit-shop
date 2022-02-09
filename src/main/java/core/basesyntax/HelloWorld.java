package core.basesyntax;

import core.basesyntax.gettingreport.GettingNewReportImpl;
import core.basesyntax.tranzactions.MakingDailyTransactions;
import core.basesyntax.tranzactions.MakingDailyTransactionsImpl;
/**
 * Feel free to remove this class and create your own.
 */

public class HelloWorld {
    public static void main(String[] args) {
        MakingDailyTransactions makingDailyTransactions = new MakingDailyTransactionsImpl();
        makingDailyTransactions.makeAllTransactions("recent.csv");
        GettingNewReportImpl report = new GettingNewReportImpl();
        report.getReport();
    }
}
