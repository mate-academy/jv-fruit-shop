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
    private final ReaderService readerService = new ReaderServiceImpl();
    private final ParserService parserService = new ParserServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();

    public UserServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
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
