package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ParseServiceImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.net.URL;
import java.util.List;

public class Main {
    private static final String[] FILE_NAMES =
            new String[]{"input1.csv", "input2.csv", "input3.csv"};

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        ParseService parseService = new ParseServiceImpl();
        ReportService reportService = new ReportServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        ClassLoader classLoader = Main.class.getClassLoader();
        for (String fileName : FILE_NAMES) {
            URL resources = classLoader.getResource(fileName);
            List<FruitTransaction> fruitTransactions = parseService.parse(
                    fileReader.readFromFile(new File(resources.getFile())));
            for (FruitTransaction fruitTransaction : fruitTransactions) {
                operationStrategy
                        .get(fruitTransaction.getOperation())
                        .handle(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
            }
            System.out.println(reportService.generateReport() + System.lineSeparator());
        }
    }
}
