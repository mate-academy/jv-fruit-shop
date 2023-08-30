package core.basesyntax;

import core.basesyntax.service.ConvertService;
import core.basesyntax.service.ProcessData;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.ConvertServiceImpl;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.serviceimpl.ProcessDataimpl;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportService;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import java.util.List;

public class FruitShop {
    private static final String pathToRead = "src/main/resources/filename.csv";
    private static final String pathToWrite = "src/main/resources/result.csv";

    public static void main(String[] args) {

        ReaderService readerService = new ReaderServiceImpl();
        List<String> fileLines = readerService.read(pathToRead);

        ConvertService convertService = new ConvertServiceImpl();
        List<FruitTransaction> transactions = convertService.convert(fileLines);

        ProcessData processData = new ProcessDataimpl();
        processData.processData(transactions);
        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportService();

        writerService.writeToFile(pathToWrite, reportService.createReport());
    }

}
