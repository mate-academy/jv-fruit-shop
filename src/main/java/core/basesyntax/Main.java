package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileReaderImpl;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ReportServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.util.ArrayList;

public class Main {
    private static final String[] FILE_NAMES =
            new String[]{"input1.csv", "input2.csv", "input3.csv"};

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        ReportService reportService = new ReportServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        for (String fileName : FILE_NAMES) {
            ArrayList<FruitTransaction> fruitTransactions =
                    fileReader.readFromFile(new File(fileName));
            for (FruitTransaction fruitTransaction : fruitTransactions) {
                operationStrategy
                        .get(fruitTransaction.getOperation())
                        .handle(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
            }
            System.out.println(reportService.generateReport() + System.lineSeparator());
        }
    }
}
