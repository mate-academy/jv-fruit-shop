package core.basesyntax.service.impl;

import core.basesyntax.dao.ActivityDaoDb;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ContentReader;
import core.basesyntax.service.ContentWriter;
import core.basesyntax.service.ParseTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;

public class TransactionServiceImpl implements TransactionService {
    private final ActivityDaoDb activityDaoDb;
    private final ContentReader contentReader;
    private final ContentWriter contentWriter;
    private final ParseTransaction parseTransaction;
    private final ReportService reportService;

    public TransactionServiceImpl(ActivityDaoDb activityDaoDb, ContentReader contentReader,
                                  ContentWriter contentWriter, ParseTransaction parseTransaction,
                                  ReportService reportService) {
        this.activityDaoDb = activityDaoDb;
        this.contentReader = contentReader;
        this.contentWriter = contentWriter;
        this.parseTransaction = parseTransaction;
        this.reportService = reportService;
    }

    @Override
    public void moveDataFromFileToDb(String fromFile) {
        for (FruitTransaction fruitTransaction :
                parseTransaction.processing(contentReader.read(fromFile))) {
            activityDaoDb.add(fruitTransaction);
        }
    }

    @Override
    public void createReport(String toFile) {
        contentWriter.write(reportService.makeReport(), toFile);
    }
}
