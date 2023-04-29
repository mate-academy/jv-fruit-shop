import dao.CsvDao;
import dao.CsvDaoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.CalculationService;
import service.FruitCalculation;
import service.Parser;
import service.impl.CalculationServiceImpl;
import service.impl.FruitCalculationIncome;
import service.impl.FruitCalculationOutcome;
import service.impl.ParserImpl;

public class Main {
    private static final String FROM_FILE_NAME =
            "src/main/resources/type,fruit,quantity.csv";
    private static final String TO_FILE_NAME =
            "src/main/resources/report - fruit_total_balance.csv";

    public static void main(String[] args) {
        Map<Operation, FruitCalculation> calculationHandlerMap = new HashMap<>();
        calculationHandlerMap.put(Operation.RETURN, new FruitCalculationIncome());
        calculationHandlerMap.put(Operation.SUPPLY, new FruitCalculationIncome());
        calculationHandlerMap.put(Operation.BALANCE, new FruitCalculationIncome());
        calculationHandlerMap.put(Operation.PURCHASE, new FruitCalculationOutcome());

        CsvDao csvDao = new CsvDaoImpl();
        List<String> dataFromFile = csvDao.readFromFile(FROM_FILE_NAME);

        Parser parser = new ParserImpl();
        List<FruitTransaction> fruitList = parser.parse(dataFromFile);

        CalculationService calculationService = new CalculationServiceImpl(fruitList);
        Map<String, Integer> fruitBalance = calculationService.calculate(calculationHandlerMap);

        csvDao.writeToFile(fruitBalance, TO_FILE_NAME);
    }
}

