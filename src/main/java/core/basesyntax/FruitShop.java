package core.basesyntax;

import core.basesyntax.service.FileService;
import core.basesyntax.service.FileServiceImpl;
import core.basesyntax.service.ReportBuilder;
import core.basesyntax.service.ReportBuilderImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShop {
    public static final Map<String,Integer> fruitWarehouse = new HashMap<>();
    private final ReportBuilder reportBuilder = new ReportBuilderImpl();
    private final FileService fileService = new FileServiceImpl();
    private final String inputFileName = "input.txt";
    private final String outputFileName = "output.txt";

    public static void main(String[] args) {
        FruitShop store = new FruitShop();
        List<String> records = store.fileService.readFile(store.inputFileName);
        String report = store.reportBuilder.buildReport(records);
        store.fileService.writeFile(store.outputFileName, report);

    }

}
