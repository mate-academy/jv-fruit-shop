package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import java.util.List;
import java.util.Map;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.UserService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationService;
import core.basesyntax.strategy.impl.FruitStrategy;

public class UserServiceImpl implements UserService {
    private final FruitDao fruitDao;
    private final ReaderService readerService;
    private final ParserService parserService;
    private final WriterService writerService;

    public UserServiceImpl(FruitDao fruitDao,
                           ReaderService readerService,
                           ParserService parserService,
                           WriterService writerService) {
        this.fruitDao = fruitDao;
        this.readerService = readerService;
        this.parserService = parserService;
        this.writerService = writerService;
    }

    @Override
    public void formReport(Map<Operation, OperationService> operationMap,
                           String fromFile, String toFile) {
        FruitStrategy fruitStrategy = new FruitStrategy(operationMap);
        List<String> commands = readerService.readFromFile(fromFile);
        List<FruitTransaction> fruitTransactions = parserService.parse(commands);
        fruitStrategy.executeOperationServiceByOperation(fruitTransactions);
        writerService.writeToFile(toFile, fruitDao.getAll());
    }
}
