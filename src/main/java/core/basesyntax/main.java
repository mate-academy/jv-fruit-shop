package core.basesyntax;

import core.basesyntax.dao.FruitCSVImpl;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.impl.FileWriterServiceImpl;
import core.basesyntax.impl.FruitServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class main {
    public static void main(String[] args) {
//       1. read data from csv file
//       2. process these data
//       3. generate a report based on processed data
//       4. write report to new csv file

        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();
        operationOperationHandlerMap.put(FruitTransaction.Operation.b,new BalanceStrategyOperationImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.s,new SupplyStrategyOperationImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.p,new PurposeStrategyOperationImpl());
        operationOperationHandlerMap.put(FruitTransaction.Operation.r,new ReturnStrategyOperationImpl());


        final String INPUT_FILE_NAME = "FruitStore.csv";
        FruitDao fruitDao = new FruitCSVImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationOperationHandlerMap);
        List<FruitTransaction> inputData = new ReaderServiceImpl().readFromFile(INPUT_FILE_NAME);
        FruitService fruitService = new FruitServiceImpl(fruitDao,operationStrategy);
        fruitService.calculateFruit(inputData);
        ReportService reportService = new ReportServiceImpl();
        List<String[]> report = reportService.createReport();
        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.parse(report);



//        FruitDao fruitDao = new FruitCSVImpl();
//        ReaderService readerService = new ReaderServiceImpl();
//        FruitService fruitService = new FruitServiceImpl(operationStrategy);

//        System.out.println(readerService.readFromFile(FILE_NAME));
//        System.out.println(fruitService.calculateFruit(readerService.readFromFile(INPUT_FILE_NAME)));

    }
}
