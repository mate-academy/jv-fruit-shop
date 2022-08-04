package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.daoimpl.FruitDaoImpl;
import core.basesyntax.fileservice.FileReader;
import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileserviceimpl.FileReaderImpl;
import core.basesyntax.fileserviceimpl.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionConstructor;
import core.basesyntax.serviceimpl.FruitTransactionProcessorImpl;
import core.basesyntax.serviceimpl.ReportCreatorServiceImpl;
import core.basesyntax.serviceimpl.TransactionConstructorImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> fromFile = reader.readFromFile("src/main/resources/FruitProcesses.csv");

        TransactionConstructor constructor = new TransactionConstructorImpl();
        List<FruitTransaction> fruitTransactions = constructor.convert(fromFile);

        FruitTransactionProcessor processor = new FruitTransactionProcessorImpl();
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
