package core.basesyntax;

import core.basesyntax.service.DataParseService;
import core.basesyntax.service.ReadFromFileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.DataParseServiceImpl;
import core.basesyntax.service.impl.ReadFromFileServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StorageServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;

public class Main {
    private static final ReadFromFileService READ_SERVICE = new ReadFromFileServiceImpl();
    private static final TransactionProcessorImpl TRANSACTION_PROCESSOR
            = new TransactionProcessorImpl();
    private static final String PATH_FROM
            = "src/main/resources/input.csv";
    private static final String PATH_TO
            = "src/main/resources/output.csv";
    private static final StorageService STORAGESERVICE = new StorageServiceImpl();
    private static final ReportService REPORTSERVICE = new ReportServiceImpl(STORAGESERVICE);
    private static final WriterService writerService = new WriterServiceImpl();

    public static void main(String[] args) {

        List<String> inputData = READ_SERVICE.readFile(PATH_FROM);

        DataParseService listFruitTransactions = new DataParseServiceImpl();

        TRANSACTION_PROCESSOR.executeTransactions(
                listFruitTransactions.getTransactionList(inputData));

        List<String> readyReport = REPORTSERVICE.createReport();

        writerService.writeToFile(PATH_TO, readyReport);
    }
}
