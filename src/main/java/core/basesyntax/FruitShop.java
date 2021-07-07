package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.dto.FruitDto;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.FruitServiceImpl;
import core.basesyntax.service.Parser;
import core.basesyntax.service.ParserImpl;
import core.basesyntax.service.filehandler.FileHandler;
import core.basesyntax.service.filehandler.FileHandlerImpl;
import core.basesyntax.service.strategy.StrategySupplier;
import core.basesyntax.service.strategy.StrategySupplierImpl;
import core.basesyntax.service.validator.Validator;
import core.basesyntax.service.validator.ValidatorImpl;
import java.util.List;

public class FruitShop {
    private static final String INPUT_DATA = "src\\main\\resources\\inputFile.txt";
    private static final String OUTPUT_DATA = "src\\main\\resources\\output.txt";

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandlerImpl();
        Validator validator = new ValidatorImpl();
        Parser parser = new ParserImpl(validator);
        FruitDao fruitDao = new FruitDaoImpl();
        StrategySupplier supplier = new StrategySupplierImpl(fruitDao);
        FruitService fruitService = new FruitServiceImpl(supplier, fruitDao);

        List<String> fileData = fileHandler.readFromFile(INPUT_DATA);
        List<FruitDto> dtoList = parser.parseToDto(fileData);
        fruitService.processRequests(dtoList);
        String currentStorageState = fruitService.getCurrentStorageState();
        fileHandler.writeToFile(OUTPUT_DATA, currentStorageState);
    }
}
