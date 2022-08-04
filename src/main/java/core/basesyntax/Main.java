package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.daoimpl.FruitDaoImpl;
import core.basesyntax.fileservice.FileReader;
import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileserviceimpl.FileReaderImpl;
import core.basesyntax.fileserviceimpl.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.reportservice.ReportCreatorService;
import core.basesyntax.reportserviceimpl.ReportCreatorServiceImpl;
import core.basesyntax.transactionprocessor.FruitTransactionProcessor;
import core.basesyntax.transactionprocessor.TransactionConstructor;
import core.basesyntax.transactionprocessorimpl.FruitTransactionProcessorImpl;
import core.basesyntax.transactionprocessorimpl.TransactionConstructorImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> lines = reader.readFromFile("src/main/resources/FruitProcesses.csv");

        TransactionConstructor constructor = new TransactionConstructorImpl();
        List<FruitTransaction> fruitTransactions = constructor.convert(lines);

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
