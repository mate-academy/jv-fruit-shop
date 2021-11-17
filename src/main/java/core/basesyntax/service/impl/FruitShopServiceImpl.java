package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.service.BatchLoader;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.Reader;
import core.basesyntax.service.ReportMaker;
import core.basesyntax.service.Validator;
import core.basesyntax.service.Writer;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private final Reader reader;
    private final Validator validator;
    private final StorageDao storageDao;
    private final ReportMaker reportMaker;
    private final Writer writer;
    private final BatchLoader batchLoader;

    public FruitShopServiceImpl(Reader reader, Validator validator, BatchLoader partyMaker,
                                StorageDao storageDao, ReportMaker reportMaker, Writer writer) {
        this.reader = reader;
        this.validator = validator;
        this.batchLoader = partyMaker;
        this.storageDao = storageDao;
        this.reportMaker = reportMaker;
        this.writer = writer;
    }

    @Override
    public void runShop() {
        List<String> fileData = reader.read();
        if (validator.validate(fileData)) {
            batchLoader.loadBatch(fileData);
            String report = reportMaker.makeReport(storageDao);
            writer.writeToFile(report);
        }
    }
}
