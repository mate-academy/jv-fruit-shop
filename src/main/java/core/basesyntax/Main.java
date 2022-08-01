package core.basesyntax;

import core.basesyntax.dao.DaoFruitStorage;
import core.basesyntax.dao.DaoTransactions;
import core.basesyntax.daoimpl.DaoFruitStorageImpl;
import core.basesyntax.daoimpl.DaoTransactionsImpl;
import core.basesyntax.fileservice.FileReader;
import core.basesyntax.fileservice.FileWriter;
import core.basesyntax.fileserviceimpl.FileReaderImpl;
import core.basesyntax.fileserviceimpl.FileWriterImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionConstructor;
import core.basesyntax.serviceimpl.OperationServiceImpl;
import core.basesyntax.serviceimpl.ReportServiceImpl;
import core.basesyntax.serviceimpl.TransactionConstructorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader reader = new FileReaderImpl();
        List<String> fromFile = reader.readFromFile("src/main/resources/FruitProcesses.csv");

        TransactionConstructor constructor = new TransactionConstructorImpl();
        List<FruitTransaction> fruitTransactions = constructor.packToObject(fromFile);

        DaoTransactions transactions = new DaoTransactionsImpl();
        transactions.addToStorage(fruitTransactions);

        OperationService service = new OperationServiceImpl();
        service.applyAll(transactions.getFromTS());

        DaoFruitStorage fs = new DaoFruitStorageImpl();

        ReportService reportService = new ReportServiceImpl();
        List<String> report = reportService.createReport(fs.getFromFruitStorage());

        FileWriter writer = new FileWriterImpl();
        writer.writeToFile("src/main/resources/FruitsEndDayBalance.csv", report);
    }
}
