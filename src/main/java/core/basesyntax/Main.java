package core.basesyntax;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.dao.ActivityDaoDbImpl;
import core.basesyntax.service.ContentReader;
import core.basesyntax.service.ContentWriter;
import core.basesyntax.service.ParseFruitTransaction;
import core.basesyntax.service.ParseTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.ContentReaderImpl;
import core.basesyntax.service.impl.ContentWriterImpl;
import core.basesyntax.service.impl.ParseFruitTransactionImpl;
import core.basesyntax.service.impl.ParseTransactionImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.strategy.TypeActivityStrategyImpl;
import core.basesyntax.service.strategy.maps.TypeActivityToOperation;

public class Main {
    public static void main(String[] args) {
        ActivityDaoDb activityDaoDb = new ActivityDaoDbImpl();
        ContentReader contentReader = new ContentReaderImpl();
        ContentWriter contentWriter = new ContentWriterImpl();
        ParseFruitTransaction parseFruitTransaction = new ParseFruitTransactionImpl();
        ParseTransaction parseTransaction = new ParseTransactionImpl(parseFruitTransaction);
        ReportService reportService = new ReportServiceImpl(
                activityDaoDb,
                new TypeActivityStrategyImpl(TypeActivityToOperation.getMap()));

        TransactionService transactionService = new TransactionServiceImpl(activityDaoDb,
                contentReader, contentWriter, parseTransaction, reportService);

        transactionService.moveDataFromFileToDb("data2508202.csv");
        transactionService.createReport("report.csv");
    }
}
