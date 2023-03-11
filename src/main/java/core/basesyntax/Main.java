package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.Report;
import core.basesyntax.service.ReportImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static final Map<String,Integer> fruitMap = new HashMap<>();
    private final Report report = new ReportImpl();
    private final FileService fileService = new FileServiceImpl();
    private final String inputFileName = "src/main/resources/input.csv";
    private final String outputFileName = "src/main/resources/output.csv";

    public static void main(String[] args) {
        Main store = new Main();
        List<String> records = store.fileService.readFile(store.inputFileName);
        String report = store.report.report(records);
        store.fileService.writeFile(store.outputFileName, report);
    }
}
