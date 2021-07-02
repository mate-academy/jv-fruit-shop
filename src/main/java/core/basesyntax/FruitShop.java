package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.OperationHandler;
import core.basesyntax.model.OperationHandlerImpl;
import core.basesyntax.service.FruitReportServiceImpl;
import core.basesyntax.service.ShopReportService;
import core.basesyntax.service.filehandler.FileHandler;
import core.basesyntax.service.filehandler.FileHandlerImpl;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import java.util.List;

public class FruitShop {
    private static final String INPUT_DATA = ".\\src\\main\\java\\core\\basesyntax\\inputFile.txt";
    private static final String OUTPUT_DATA = ".\\src\\main\\java\\core\\basesyntax\\output.txt";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandlerImpl();
        Validator validator = new ValidatorImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        OperationHandler operationHandler = new OperationHandlerImpl(fruitDao);
        ShopReportService fruitReportService = new FruitReportServiceImpl(validator,
                operationHandler);

        List<String> list = fileHandler.readFromFile(INPUT_DATA);
        fileHandler.writeToFile(OUTPUT_DATA, fruitReportService.makeReport(list));
    }
}
