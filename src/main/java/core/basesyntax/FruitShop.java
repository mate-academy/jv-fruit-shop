package core.basesyntax;

import core.basesyntax.model.OperationHandlerImpl;
import core.basesyntax.service.ShopReportService;
import core.basesyntax.service.FruitReportServiceImpl;
import core.basesyntax.service.fileHandler.FileHandler;
import core.basesyntax.service.fileHandler.FileHandlerImpl;
import core.basesyntax.service.validator.ValidatorImpl;

import java.util.List;


public class FruitShop {
    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandlerImpl();
        ShopReportService fruitReportService = new FruitReportServiceImpl(new ValidatorImpl(), new OperationHandlerImpl());

        List<String> list = fileHandler.readFromFile(".\\src\\main\\java\\core\\basesyntax\\inputFile.txt");
        fileHandler.writeToFile(".\\src\\main\\java\\core\\basesyntax\\output.txt", fruitReportService.makeReport(list));
    }
}
