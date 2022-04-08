package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private static final CsvFileReaderService reader = new CsvFileReaderServiceImpl();
    private static final OperationStrategy strategy = new OperationStrategyImpl();
    private static final CsvFileWriterService writer = new CsvFileWriterServiceImpl();
    private static final ReportCreator reporter = new ReportCreatorImpl();

    @Override
    public void update(String pathToInputFile, String pathToOutputFile) {

        List<FruitTransaction> list = reader.readFromFile(pathToInputFile);

        list.forEach(f -> strategy.process(f.getOperation(), f.getFruit(), f.getQuantity()));

        writer.writeToFile(pathToOutputFile, reporter.getReport());
    }
}
