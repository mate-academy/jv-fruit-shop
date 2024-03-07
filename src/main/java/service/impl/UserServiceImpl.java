package service.impl;

import dao.FruitDao;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.ParserService;
import service.ReaderService;
import service.UserService;
import service.WriterService;
import strategy.OperationService;
import strategy.impl.FruitStrategy;

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
