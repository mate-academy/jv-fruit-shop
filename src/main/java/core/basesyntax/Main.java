package core.basesyntax;

import core.basesyntax.db.FruitDao;
import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionConvertor;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionConvertorImpl;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> lines = reader.readFromFile("src/main/resources/FruitProcesses.csv");

        TransactionConvertor constructor = new TransactionConvertorImpl();
        List<FruitTransaction> fruitTransactions = constructor.convert(lines);

        FruitTransactionProcessor processor =
                new FruitTransactionProcessorImpl(new OperationStrategyImpl());
        processor.process(fruitTransactions);

        FruitDao fruitDao = new FruitDaoImpl();
        Map<String, Integer> fruits = fruitDao.getAll();

        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        String report = reportCreatorService.createReport(fruits);
        System.out.println(report);

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile("src/main/resources/FruitsEndDayBalance.csv", report);
    }
}
