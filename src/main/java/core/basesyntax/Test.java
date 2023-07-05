package core.basesyntax;

import core.shop.model.ActivityType;
import core.shop.service.FileService;
import core.shop.service.ReportService;
import core.shop.service.ShopOperationsService;
import core.shop.service.impl.FileServiceImpl;
import core.shop.service.impl.ReportServiceImpl;
import core.shop.service.impl.ShopOperationsServiceImpl;
import java.util.List;

public class Test {
    private static final FileService fileService = new FileServiceImpl();
    private static final ReportService reportService = new ReportServiceImpl();
    private static final String DATABASE_FILE = "src/database.csv";
    private static final ShopOperationsService shopOperation = new ShopOperationsServiceImpl();

    public static void main(String[] args) {

        List<String> readAllList = fileService.read(DATABASE_FILE);
        System.out.println(readAllList);
        //Add several operations to the database.csv
        shopOperation.addOperationToCsv(ActivityType.SUPPLY, "banana", 15);
        shopOperation.addOperationToCsv(ActivityType.PURCHASE, "banana", 5);
        shopOperation.addOperationToCsv(ActivityType.RETURN, "banana", 10);

        shopOperation.addOperationToCsv(ActivityType.BALANCE, "cherry", 15);
        shopOperation.addOperationToCsv(ActivityType.PURCHASE, "cherry", 5);
        shopOperation.addOperationToCsv(ActivityType.RETURN, "cherry", 3);

        reportService.generateReport(fileService.read(DATABASE_FILE));

    }

}
