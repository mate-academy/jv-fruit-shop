package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriteServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class HelloWorld {
    public static void main(String[] args) {
        String filePath =
                "/Users/macbook/IdeaProjects/jv-fruit-shop/src/main/resources/InputFile.csv";
        FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> readFromFile = fileReaderService.readFile(filePath);
        FruitDao fruitDao = new FruitDaoImpl();
        ReportService reportService = new ReportServiceImpl(fruitDao);
        reportService.calculateDataForReport(readFromFile);
        FileWriterService fileWriterService = new FileWriteServiceImpl();
        fileWriterService.writeReport(fruitDao.getFruitList());
    }
}
