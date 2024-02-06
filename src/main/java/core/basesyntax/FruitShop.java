package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.FruitStorageDaoImpL;
import core.basesyntax.converter.StringTransactionConverterImpl;
import core.basesyntax.fileservise.CsvFileReader;
import core.basesyntax.fileservise.CsvFileReaderImpl;
import core.basesyntax.fileservise.CsvFileWriter;
import core.basesyntax.fileservise.CsvFileWriterImpl;
import core.basesyntax.model.Transaction;
import core.basesyntax.report.ReportGenerator;
import core.basesyntax.report.ReportGeneratorImpl;
import core.basesyntax.strategy.OperationGetter;
import core.basesyntax.strategy.OperationGetterIpml;
import core.basesyntax.transactionsService.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    public static void main(String[] args) {

        String fileName = "src/main/java/core/basesyntax/csvFiles/data.csv";
        String reportFileName = "src/main/java/core/basesyntax/csvFiles/report.csv";

        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpL();

        Map<Transaction.TransactionType, OperationHandler> transactionMap = new HashMap<>();
        transactionMap.put(Transaction.TransactionType.BALANCE, new OperationBalance(fruitStorageDao));
        transactionMap.put(Transaction.TransactionType.PURCHASE, new OperationPurchase(fruitStorageDao));
        transactionMap.put(Transaction.TransactionType.RETURN, new OperationReturn(fruitStorageDao));
        transactionMap.put(Transaction.TransactionType.SUPPLY, new OperationSupply(fruitStorageDao));

        CsvFileReader csvReader = new CsvFileReaderImpl();
        List<String> stringTransactions = csvReader.getTransactionsFromFile(fileName);

        StringTransactionConverterImpl stringToTransactionConverter = new StringTransactionConverterImpl();
        List<Transaction> transactions = stringToTransactionConverter.convert(stringTransactions);

        OperationGetter operationGetter = new OperationGetterIpml(transactionMap);

        OperationHandler operationHandler;
        for (Transaction transaction : transactions) {
            operationHandler = operationGetter.getOperation(transaction);
            operationHandler.proceed(transaction);
        }

        ReportGenerator reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generateReport(fruitStorageDao.getAllFromStorage());

        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        csvFileWriter.writeToFile(report, reportFileName);
    }
}
