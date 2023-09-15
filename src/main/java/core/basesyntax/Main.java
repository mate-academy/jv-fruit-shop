package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ProcessService;
import core.basesyntax.service.WriteService;
import core.basesyntax.service.serviceimpl.CreateReportServiceImpl;
import core.basesyntax.service.serviceimpl.ParseServiceImpl;
import core.basesyntax.service.serviceimpl.ProcessServiceImpl;
import core.basesyntax.service.serviceimpl.ReaderServiceImpl;
import core.basesyntax.service.serviceimpl.WriteServiceImpl;
import core.basesyntax.storage.Storage;
import java.util.HashMap;
import java.util.List;

public class Main {
    private static final String FILE_PATH_TO_READ = "src\\recources\\input.csv";
    private static final String FILE_PATH_TO_WRITE = "src\\recources\\report.csv";

    public static void main(String[] args) {
        Storage.setFruits(new HashMap<>());
        List<String> lines = new ReaderServiceImpl().read(FILE_PATH_TO_READ);
        List<FruitTransaction> fruitTransactionList = new ParseServiceImpl().parse(lines);
        ProcessService processService = new ProcessServiceImpl();
        processService.processTransactions(fruitTransactionList);
        String report = new CreateReportServiceImpl().createReport();
        WriteService writeService = new WriteServiceImpl();
        writeService.writeToFile(FILE_PATH_TO_WRITE, report);
    }
}
