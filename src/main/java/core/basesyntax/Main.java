package core.basesyntax;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.impl.ConvertServiceImpl;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String PATH_FILE_TO_READ = "src/main/resources/database.csv";
    private static final String PATH_FILE_TO_WRITE = "src/main/resources/dailyStatistic.csv";

    public static void main(String[] args) {
        List<String> linesFromFile = new ReaderServiceImpl().fileReader(PATH_FILE_TO_READ);
        List<FruitTransaction> fruitTransactions
                = new ConvertServiceImpl().convertData(linesFromFile);
        StorageImpl storage = new StorageImpl();
        OperationStrategy strategy = new OperationStrategy(storage);
        FruitService fruitService = new FruitServiceImpl(strategy);
        fruitService.process(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.report(storage.getAll());
        WriterService writerService = new WriterServiceImpl();
        writerService.fileWriter(PATH_FILE_TO_WRITE, report);
    }
}
