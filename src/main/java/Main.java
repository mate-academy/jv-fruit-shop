import core.basesyntax.shop.impl.Report;

public class Main {
    public static void main(String[] args) {
        Report report = new Report();
        report.createReport("correct.csv", "output.csv");
        //report.createReport("emptyLineBottom.csv", "output.csv");
        //report.createReport("corrupted.csv", "output.csv");
        //report.createReport("balanceLessThanReturn.csv", "output.csv");
        //report.createReport("purchaseMoreThanBalance.csv", "output.csv");
        //report.createReport("balance_2_times.csv", "output.csv");
        //report.createReport("invalid.csv", "output.csv");
        //report.createReport("correct.txt", "output.csv");
    }
}
