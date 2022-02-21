package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.dto.FruitDto;
import core.basesyntax.service.FileWriterImpl;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportCreatorImpl;
import core.basesyntax.service.impl.FileReaderService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String fileInput = "src/main/resources/dataInput.csv";
        String fileOutPut = "src/main/resources/dataOutput.csv";

        OperationHandler strategyType = new OperationHandler();
        FileReaderService readData = new FileReaderServiceImpl();
        String s = readData.readFromFile(fileInput);
        FruitTransactionServiceImpl fruitTransactionService = new FruitTransactionServiceImpl();
        List<FruitDto> parsedData = fruitTransactionService.parser(s);
        strategyType.processFruitOperation(parsedData);
        ReportCreatorImpl creator = new ReportCreatorImpl();
        FruitDao fruitDao = new FruitDaoImpl();
        List<Fruit> all = fruitDao.getAll();
        String report = creator.createReport(all);
        FileWriterService writer = new FileWriterImpl();
        writer.writeDataToFile(report, fileOutPut);

    }
}
