package core.basesyntax;

import core.basesyntax.db.StorageImpl;
import core.basesyntax.impl.AnalysisServiceImpl;
import core.basesyntax.impl.ConvertServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.AnalysisService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class Main {
    private static final String PATH_FILE_TO_READ = "src/main/resources/database.csv";
    private static final String PATH_FILE_TO_WRITE = "src/main/resources/dailyStatistic.csv";

    public static void main(String[] args) {
        List<String> filedReader = new ReaderServiceImpl().fileReader(PATH_FILE_TO_READ);
        List<FruitTransaction> fruitTransactions
                = new ConvertServiceImpl().convertData(filedReader);
        StorageImpl storage = new StorageImpl();
        OperationStrategy strategy = new OperationStrategy(storage);
        AnalysisService analysisService = new AnalysisServiceImpl(strategy);
        analysisService.processing(fruitTransactions);
        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.report(storage.getAll());
        WriterService writerService = new WriterServiceImpl();
        writerService.fileWriter(PATH_FILE_TO_WRITE, report);
    }
}
