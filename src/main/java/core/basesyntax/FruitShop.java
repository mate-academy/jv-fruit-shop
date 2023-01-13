package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.serviceimpl.ParserServiceImpl;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.StrategyImpl;
import java.util.List;

public class FruitShop {
    private static final String INPUT_FILE_NAME = "src/main/java/files/data.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/java/files/report.csv";

    public static void main(String[] args) {
        Strategy strategy = new StrategyImpl();

        List<String> dataFromFile = new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        List<Transaction> transactions = new ParserServiceImpl().parse(dataFromFile);

        for (Transaction transaction : transactions) {
            strategy.getStrategy(transaction);
        }

        String report = new ReportServiceImpl().getReport();
        new WriterServiceImpl().writeToFile(report, OUTPUT_FILE_NAME);
    }
}
