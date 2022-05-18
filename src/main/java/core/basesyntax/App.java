package core.basesyntax;

import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.service.impl.CalculateFruitsBalance;
import core.basesyntax.service.impl.GenerateFruitsBalanceReport;
import core.basesyntax.service.impl.ReadTransactionsFromCsv;
import core.basesyntax.service.impl.TransformFruitsCsv;
import core.basesyntax.service.impl.WriteReportCsv;

public class App {
    public static void main(String[] args) {
        new StorageDaoImpl().addList(
                new TransformFruitsCsv().getTransactions(
                new ReadTransactionsFromCsv()
                        .toList("src/main/resources/input.csv")));
        new WriteReportCsv().outReport(
                new GenerateFruitsBalanceReport().getReport(
                        new CalculateFruitsBalance().getBalance()),
                "src/main/resources/report.csv");
        System.out.println("It's over");
    }
}
