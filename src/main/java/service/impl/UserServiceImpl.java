package service.impl;

import com.sun.tools.javac.Main;
import dao.FruitDao;
import dao.FruitDaoImpl;
import model.FruitTransaction;
import model.Operation;
import service.FruitTransactionService;
import service.ParserService;
import service.ReaderService;
import service.UserService;
import service.WriterService;
import strategy.OperationService;
import strategy.impl.FruitStrategy;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    private final FruitDao fruitDao;
    private final ReaderService readerService = new ReaderServiceImpl();
    private final ParserService parserService = new ParserServiceImpl();
    private final WriterService writerService = new WriterServiceImpl();

    public UserServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public void formReport(Map<Operation, OperationService> operationServiceMap, String fromFile, String toFile) {
        FruitStrategy fruitStrategy = new FruitStrategy(operationServiceMap);
        List<String> commands = readerService.readFromFile(fromFile);
        List<FruitTransaction> fruitTransactions = parserService.parse(commands);
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl(fruitDao);
        List<FruitTransaction> processedCommands = fruitTransactionService.processFruitTransaction(fruitTransactions);
        fruitStrategy.executeOperationServiceByOperation(processedCommands);
        writerService.writeToFile(toFile, fruitDao.getAll());
    }
}
