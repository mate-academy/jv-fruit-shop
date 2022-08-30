package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ContentReader;
import core.basesyntax.service.ContentWriter;
import core.basesyntax.service.ParseTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.strategy.TypeActivityStrategy;

public class TransactionServiceImpl implements TransactionService {
    private final ContentReader contentReader;
    private final ContentWriter contentWriter;
    private final ParseTransaction parseTransaction;
    private final ReportService reportService;
    private final TypeActivityStrategy typeActivityStrategy;

    public TransactionServiceImpl(ContentReader contentReader, ContentWriter contentWriter,
                                  ParseTransaction parseTransaction, ReportService reportService,
                                  TypeActivityStrategy typeActivityStrategy) {
        this.contentReader = contentReader;
        this.contentWriter = contentWriter;
        this.parseTransaction = parseTransaction;
        this.reportService = reportService;
        this.typeActivityStrategy = typeActivityStrategy;
    }

    @Override
    public void moveDataFromFileToDb(String fromFile) {
        for (FruitTransaction fruitTransaction :
                parseTransaction.processing(contentReader.read(fromFile))) {
            typeActivityStrategy.strategy(fruitTransaction.getType()).calculate(fruitTransaction);
        }
    }

    @Override
    public void createReport(String toFile) {
        contentWriter.write(reportService.makeReport(), toFile);
    }
}
