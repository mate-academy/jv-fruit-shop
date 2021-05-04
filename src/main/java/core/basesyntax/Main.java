package core.basesyntax;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitDataDto;
import service.ActivityStrategyImpl;
import service.DataParser;
import service.DataParserImpl;
import service.ReportGenerator;
import service.ReportGeneratorImpl;
import service.ShopService;
import service.ShopServiceImpl;
import service.actions.ActivityHandler;
import service.actions.Balance;
import service.actions.Purchase;
import service.actions.SupplyOrReturn;
import service.file.FileReader;
import service.file.FileReaderImpl;
import service.file.FileWriter;
import service.file.FileWriterImpl;

public class Main {
    public static final String FILE_TO_READ = "src\\main\\resources\\fruits.csv";
    public static final String FILE_TO_WRITE = "src\\main\\resources\\report.csv";
    public static final String BALANCE = "b";
    public static final String PURCHASE = "p";
    public static final String RETURN = "r";
    public static final String SUPPLY = "s";
    private static Map<String, ActivityHandler> map = new HashMap<>();
    private static FruitDao fruitDao = new FruitDaoImpl();
    private static FileWriter fileWriter = new FileWriterImpl();

    public static void main(String[] args) {
        map.put(BALANCE, new Balance(fruitDao));
        map.put(PURCHASE, new Purchase(fruitDao));
        map.put(RETURN, new SupplyOrReturn(fruitDao));
        map.put(SUPPLY, new SupplyOrReturn(fruitDao));
        ActivityStrategyImpl activityStrategy = new ActivityStrategyImpl(map);
        FileReader fileReader = new FileReaderImpl();
        DataParser dataParser = new DataParserImpl();
        List<FruitDataDto> fruitDataDtoList = dataParser
                .parseData(fileReader.readFile(FILE_TO_READ));
        ShopService shopService = new ShopServiceImpl(activityStrategy);
        shopService.doAction(fruitDataDtoList);
        ReportGenerator reportGenerator = new ReportGeneratorImpl(fileWriter, fruitDao);
        reportGenerator.generateReport(FILE_TO_WRITE);
    }
}
