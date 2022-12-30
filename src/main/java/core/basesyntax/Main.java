package core.basesyntax;

import core.basesyntax.service.impl.ProcessServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.WriteServiceImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src/main/resources/file.csv");
        File toFileName = new File("src/main/resources/report.csv");
        Map<String, Integer> fruitMap = new HashMap<>();
        ReaderServiceImpl readerService = new ReaderServiceImpl();
        ProcessServiceImpl processService = new ProcessServiceImpl();
        ReportServiceImpl reportService = new ReportServiceImpl();
        WriteServiceImpl writeService = new WriteServiceImpl();
        String lines = readerService.readFromFile(file);
        String report = reportService
                .getReport(processService.getQuantity(lines, fruitMap), fruitMap);
        writeService.writeReport(toFileName, report);
    }
}
