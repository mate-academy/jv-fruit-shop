package core.basesyntax;

import dao.FruitStorageDao;
import dao.FruitStorageDaoImpl;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.fruittransactionparser.FruitTransactionParser;
import service.fruittransactionparser.FruitTransactionParserImpl;
import service.report.ReportService;
import service.report.ReportServiceImpl;
import service.transactionexecutor.TransactionExecutor;
import service.transactionexecutor.TransactionExecutorImpl;
import service.writereadcsv.FileReader;
import service.writereadcsv.FileReaderImp;
import service.writereadcsv.FileWriter;
import service.writereadcsv.FileWriterImpl;
import strategy.operationmap.OperationMapImpl;
import strategy.operationstrategy.OperationStrategy;
import strategy.operationstrategy.OperationStrategyImpl;
import strategy.transactionhandlers.TransactionHandler;

public class Main {
    private static final String FILE_TO_WRITE = "src/main/resources/outputdate/report.csv";
    private static final String FILE_TO_READ = "src/main/resources/input/fruit.csv";

    public static void main(String[] args) {
        FileReader readCsv = new FileReaderImp();
        List<String> readFromFileCsv = readCsv.readFromFileCsv(FILE_TO_READ);
        FruitTransactionParser parse = new FruitTransactionParserImpl();
        List<FruitTransaction> list = parse.parseToFruitTransactions(readFromFileCsv);
        Map<FruitTransaction.Operation, TransactionHandler> map = new OperationMapImpl()
                .getOperationMap();
        OperationStrategy strategy = new OperationStrategyImpl(map);
        TransactionExecutor executor = new TransactionExecutorImpl(strategy);
        executor.executeTransaction(list);
        FruitStorageDao dao = new FruitStorageDaoImpl();
        ReportService reportService = new ReportServiceImpl(dao);
        String reportToWrite = reportService.getReport();
        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFileCsv(reportToWrite,FILE_TO_WRITE);
    }
}
