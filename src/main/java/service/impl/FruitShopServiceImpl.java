package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.FruitCalculator;
import service.FruitOperationParser;
import service.FruitOperationTypeParser;
import service.FruitShopService;
import service.Reader;
import service.ReportService;
import service.Writer;

public class FruitShopServiceImpl implements FruitShopService {

    private final Reader reader = new FileReaderImpl();
    private final FruitCalculator fruitCalculator = new FruitCalculatorImpl();

    private final FruitOperationTypeParser fruitOperationTypeParser
            = new FruitOperationTypeParserImpl();
    private final FruitOperationParser fruitOperationParser
            = new FruitOperationParserImpl(fruitOperationTypeParser);

    private final FruitDao fruitDao = new FruitDaoImpl();
    private final ReportService reportService = new ReportServiceImpl(fruitDao);

    private final Writer writer = new FileWriter();

    @Override
    public void processData(String readFromFileName, String writeToFileName) {
        List<String> listOfData = reader.getData("src/main/resources/" + readFromFileName);
        List<FruitTransaction> fruits
                = fruitOperationParser.parseFruitOperationList(listOfData);
        fruitCalculator.calculateFruit(fruits);
        String stringReport = reportService.getReport();
        writer.writeToFile("src/main/resources/" + writeToFileName, stringReport);
    }
}
