import core.basesyntax.db.Storage;
import core.basesyntax.impl.OperationStrategyImpl;
import core.basesyntax.impl.ParserServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportServiceImpl;
import core.basesyntax.impl.WriterServiceImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //reader
        String addressInputFile = "/src/main/java/core/recourses/input.csv";
        ReaderService readerService = new ReaderServiceImpl();
        List<String> data = new ArrayList<>();
        readerService.readFromFile(addressInputFile, data);
        //parser
        ParserService parserService = new ParserServiceImpl();
        List<FruitTransaction> listOfTransaction = parserService.parser(data);
        //service
        OperationStrategy operationStrategy = new OperationStrategyImpl();
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationStrategy.getOperationAndProcess(listOfTransaction, operationHandlerMap);
        //report
        ReportService reportService = new ReportServiceImpl();
        List<String> stringList = reportService.report(Storage.getFruits());
        //writer
        WriterService writerService = new WriterServiceImpl();
        String addressReportFile = "/src/main/java/core/recourses/report.csv";
        writerService.writeToFile(stringList, addressReportFile);
    }
}
