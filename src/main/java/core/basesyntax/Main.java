package core.basesyntax;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.dao.ActivityDaoDbImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ContentReader;
import core.basesyntax.service.ContentWriter;
import core.basesyntax.service.ParseTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.ContentReaderImpl;
import core.basesyntax.service.impl.ContentWriterImpl;
import core.basesyntax.service.impl.ParseTransactionImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.strategy.TypeActivityStrategy;
import core.basesyntax.service.strategy.TypeActivityStrategyImpl;
import core.basesyntax.service.strategy.handlers.ActivityHandler;
import core.basesyntax.service.strategy.maps.TypeActivityToOperation;
import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ActivityDaoDb activityDaoDb = new ActivityDaoDbImpl();
        ContentReader contentReader = new ContentReaderImpl();
        ContentWriter contentWriter = new ContentWriterImpl();
        ParseTransaction parseTransaction = new ParseTransactionImpl();
        ReportService reportService = new ReportServiceImpl(activityDaoDb);
        TypeActivityToOperation typeActivityToOperation =
                new TypeActivityToOperation(activityDaoDb);
        TypeActivityStrategy typeActivityStrategy =
                new TypeActivityStrategyImpl(typeActivityToOperation);
        String resourcesPath = "src" + File.separator + "main" + File.separator
                + "resources" + File.separator;

        List<String> list = contentReader.read(resourcesPath + "data2508202.csv");
        for (FruitTransaction fruitTransaction : parseTransaction.processing(list)) {
            ActivityHandler handler = typeActivityStrategy
                    .getHandlerByTypeActivity(fruitTransaction.getType());
            handler.calculate(fruitTransaction);
        }
        contentWriter.write(reportService.makeReport(), resourcesPath + "report.csv");
    }
}
