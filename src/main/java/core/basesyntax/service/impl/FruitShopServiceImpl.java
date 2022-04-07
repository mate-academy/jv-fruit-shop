package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvFileReaderService;
import core.basesyntax.service.CsvFileWriterService;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class FruitShopServiceImpl implements FruitShopService {
    private static final CsvFileReaderService reader = new CsvFileReaderServiceImpl();
    private static final FruitShopDao dao = new FruitShopDaoImpl();
    private static final OperationStrategy strategy = new OperationStrategyImpl();
    private static final CsvFileWriterService writer = new CsvFileWriterServiceImpl();

    @Override
    public void update(String pathToInputFile, String pathToOutputFile) {

        List<FruitTransaction> list = reader.readFromFile(pathToInputFile);

        list.forEach(f -> strategy.activity(f.getOperation(), f.getFruit(), f.getQuantity()));

        writer.writeToFile(pathToOutputFile, dao.getReport());
    }
}
