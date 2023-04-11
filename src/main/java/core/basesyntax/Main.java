package core.basesyntax;

import core.basesyntax.service.BalanceCalculatorService;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.BalanceCalculatorServiceImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/input.csv";
    private static final String REPORT_FILE = "src/main/resources/report.csv";

    private static final FileReaderService readerService = new FileReaderServiceImpl();
    private static final ReportCreatorService reportCreatorService
            = new ReportCreatorServiceImpl();
    private static final BalanceCalculatorService balanceCalculatorService
            = new BalanceCalculatorServiceImpl();

    public static void main(String[] args) {
        List<String> strings = readerService.readFromFile(INPUT_FILE);
        balanceCalculatorService.calculate(strings);
        reportCreatorService.create(REPORT_FILE);
    }
}
