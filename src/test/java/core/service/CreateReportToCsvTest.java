package core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.dao.CsvFileReaderService;
import core.dao.DataToString;
import core.dao.DataToStringImpl;
import core.dao.FileReaderService;
import core.db.Storage;
import core.model.Operations;
import core.strategy.AmountHandler;
import core.strategy.BalanceAmountHandler;
import core.strategy.PurchaseAmountHandler;
import core.strategy.ReturnAmountHandler;
import core.strategy.SupplyAmountHandler;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CreateReportToCsvTest {
    private static DataToString dataToString;
    private static FileReaderService fileReaderService;
    private static CreateReportToFile createReportToFile;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";
    @BeforeAll
    static void beforeAll() {
        Map<Operations, AmountHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put(Operations.BALANCE, new BalanceAmountHandler());
        activitiesHandlerMap.put(Operations.SUPPLY, new SupplyAmountHandler());
        activitiesHandlerMap.put(Operations.RETURN, new ReturnAmountHandler());
        activitiesHandlerMap.put(Operations.PURCHASE, new PurchaseAmountHandler());
        ActivitiesStrategy activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        fileReaderService = new CsvFileReaderService(activitiesStrategy);
        dataToString = new DataToStringImpl();
        createReportToFile = new CreateReportToCsv();
    }

    @Test
    void testForCorrectData() {
        fileReaderService.getData("src/test/resources/FruitShopChornovola.csv");
        createReportToFile.write(dataToString.generateString(),
                "src/test/resources/ChornovolaReport.csv");
        String expected = "fruit,quantity" + System.lineSeparator() + "banana,152"
                + System.lineSeparator() + "apple,90" + System.lineSeparator();
        String actual = readFromFile("src/test/resources/ChornovolaReport.csv");
        assertEquals(expected, actual,
                String.format(STRING_FORMAT_FOR_WRONG, expected, actual));
    }

    @Test
    void secondTestForCOrrectData() {
        fileReaderService.getData("src/test/resources/FruitShopUshakova.csv");
        createReportToFile.write(dataToString.generateString(),
                "src/test/resources/UshakovaReport.csv");
        String expected = "fruit,quantity" + System.lineSeparator() + "banana,152"
                + System.lineSeparator() + "apple,90" + System.lineSeparator() + "kiwi,20"
                + System.lineSeparator() + "mango,30" + System.lineSeparator() + "lemon,60"
                + System.lineSeparator();
        String actual = readFromFile("src/test/resources/UshakovaReport.csv");
        assertEquals(expected, actual,
                String.format(STRING_FORMAT_FOR_WRONG, expected, actual));
    }

    @AfterEach
    public void clearStorage() {
        Storage.fruits.clear();
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}