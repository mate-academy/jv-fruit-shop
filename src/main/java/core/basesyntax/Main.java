package core.basesyntax;

import core.basesyntax.dao.ShopDao;
import core.basesyntax.dao.ShopDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.OperationServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import java.util.List;

public class Main {
    private static final String INPUT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/fruit_shop_input_file.csv";
    private static final String REPORT_FILE_PATH =
            "src/main/java/core/basesyntax/resources/fruit_shop_report.csv";

    public static void main(String[] args) {
        ShopDao shopDao = new ShopDaoImpl();
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> infoFromFile = fileReaderService.readFile(INPUT_FILE_PATH);
        OperationService operationService = new OperationServiceImpl();
        operationService.action(infoFromFile);

        ReportCreatorService reportCreator = new ReportCreatorServiceImpl(shopDao);
        String report = reportCreator.report();

        FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.write(REPORT_FILE_PATH, report);
    }
}

