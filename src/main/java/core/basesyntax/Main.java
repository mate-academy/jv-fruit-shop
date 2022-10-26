package core.basesyntax;

import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.StorageReadService;
import core.basesyntax.service.StorageWriteService;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.service.impl.StorageReadServiceImpl;
import core.basesyntax.service.impl.StorageWriteServiceImpl;
import java.io.File;

public class Main {
    private static final String FILE_PATH_READ = "src/main/resources/storage.txt";
    private static final String FILE_PATH_WRITE = "src/main/resources/report.txt";

    public static void main(String[] args) {
        File file = new File(FILE_PATH_READ);
        StorageReadService reader = new StorageReadServiceImpl();
        StorageWriteService writer = new StorageWriteServiceImpl();
        ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        reader.readData(file);
        String report = reportGenerator.reportGenerator();
        file = new File(FILE_PATH_WRITE);
        writer.writeFromDb(report, file);
    }
}
