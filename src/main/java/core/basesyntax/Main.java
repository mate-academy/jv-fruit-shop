package core.basesyntax;

import core.basesyntax.service.FruitService;
import core.basesyntax.service.impl.FruitServiceImpl;
import java.time.LocalDate;

public class Main {
    private static final String TEST_INCOME_FILE_NAME = "src/main/java/resources/incomeTest.csv";
    private static final String TEST_REPORT_FILE_NAME = "src/main/java/resources/"
            + LocalDate.now() + "-reportTest.csv";

    public static void main(String[] args) {
        FruitService service = new FruitServiceImpl();
        service.createReportFile(TEST_INCOME_FILE_NAME, TEST_REPORT_FILE_NAME);
    }

}
