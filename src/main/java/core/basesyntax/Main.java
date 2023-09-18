package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.util.List;

public class Main {
    private static final String FILE_PATH_TO_READ = "src\\resources\\input.csv";
    private static final String FILE_PATH_TO_WRITE = "src\\resources\\report.csv";

    public static void main(String[] args) {
        List<String> lines = new ReaderServiceImpl().readFromFile(FILE_PATH_TO_READ);
        List<FruitTransaction> fruitTransactionList = new ParseServiceImpl().parse(lines);
        new ProcessServiceImpl().processTransactions(fruitTransactionList);
        String report = new ReportCreatorServiceImpl().createReport();
        new WriteServiceImpl().writeToFile(FILE_PATH_TO_WRITE, report);
    }
}
