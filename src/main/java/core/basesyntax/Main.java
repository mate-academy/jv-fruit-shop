package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.CalculatorImpl;
import core.basesyntax.service.impl.DataParseImpl;
import core.basesyntax.service.impl.GenerateReportService;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.impl.FruitHandlerStrategyImpl;
import java.util.List;

public class Main {
    public static final String FILE_NAME = "src/main/resources/test.csv";
    public static final String REPORT_FILE_NAME = "src/main/resources/report.csv";

    public static void main(String[] args) {
        List<FruitTransaction> fruitTransactions = new DataParseImpl()
                .parseData(new ReaderServiceImpl()
                        .readFromFile(FILE_NAME));
        new CalculatorImpl(new FruitHandlerStrategyImpl()).calculate(fruitTransactions);
        String report = new GenerateReportService().writeToString();
        WriterServiceImpl writerServiceImpl = new WriterServiceImpl();
        writerServiceImpl.writeToFile(REPORT_FILE_NAME, report);
    }
}
