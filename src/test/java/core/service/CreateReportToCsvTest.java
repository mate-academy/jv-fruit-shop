package core.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import core.activities.ActivitiesHandler;
import core.activities.BalanceActivitiesHandler;
import core.activities.PurchaseActivitiesHandler;
import core.activities.ReturnActivitiesHandler;
import core.activities.SupplyActivitiesHandler;
import core.dao.GetDataFromFile;
import core.dao.GetDataFromFileCsv;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CreateReportToCsvTest {
    private static CreateReportToFile createReportToFile;
    private static GetDataFromFile getDataFromFile;
    private static ActivitiesStrategy activitiesStrategy;
    private static final String STRING_FORMAT_FOR_WRONG =
            "Wrong operation! expected: %s But was: %s";

    @BeforeAll
    public static void beforeAll() {
        Map<String, ActivitiesHandler> activitiesHandlerMap = new HashMap<>();
        activitiesHandlerMap.put("b", new BalanceActivitiesHandler());
        activitiesHandlerMap.put("s", new SupplyActivitiesHandler());
        activitiesHandlerMap.put("r", new ReturnActivitiesHandler());
        activitiesHandlerMap.put("p", new PurchaseActivitiesHandler());
        activitiesStrategy = new ActivitiesStrategyImpl(activitiesHandlerMap);
        createReportToFile = new CreateReportToCsv();
    }

    @Test
    public void testForCorrectInputData() {
        getDataFromFile = new GetDataFromFileCsv(activitiesStrategy);
        createReportToFile.createReport(getDataFromFile.getData("FruitShopChornovola.csv"),
                "ChornovolaReport.csv");
        createReportToFile.createReport(getDataFromFile.getData("FruitShopUshakova.csv"),
                "UshakovaReport.csv");
        String firstExpected = "fruit,quantity" + System.lineSeparator() + "banana,152"
                + System.lineSeparator() + "apple,90" + System.lineSeparator();
        String secondExpected = "fruit,quantity" + System.lineSeparator() + "banana,152"
                + System.lineSeparator() + "apple,90" + System.lineSeparator() + "kiwi,20"
                + System.lineSeparator() + "mango,30" + System.lineSeparator() + "lemon,60"
                + System.lineSeparator();
        String firstActual = readFromFile("ChornovolaReport.csv");
        String secondActual = readFromFile("UshakovaReport.csv");
        assertEquals(firstExpected, firstActual,
                String.format(STRING_FORMAT_FOR_WRONG, firstExpected, firstActual));
        assertEquals(secondExpected, secondActual,
                String.format(STRING_FORMAT_FOR_WRONG, secondExpected, secondActual));
    }

    @Test
    public void testForIncorrectInputData() {
        assertThrows(RuntimeException.class,() ->
                createReportToFile.createReport(getDataFromFile.getData(
                        "FruitShopLvivIncorrect.csv"), "FruitShopLvivReport.csv"));
        assertThrows(RuntimeException.class,() ->
                createReportToFile.createReport(getDataFromFile
                                .getData("FruitShopIrpinskaIncorrect.csv"),
                        "FruitShopIrpinskaReport.csv"));
        assertThrows(RuntimeException.class,() ->
                createReportToFile.createReport(getDataFromFile.getData(
                        "FruitShopChornobilskaIncorrect.csv"),
                        "FruitShopChornobylskaReport.csv"));
        assertThrows(RuntimeException.class,() ->
                createReportToFile.createReport(getDataFromFile.getData("TestTestTest.csv"),
                        "TestTestTestReport.csv"));
        assertThrows(RuntimeException.class,() -> createReportToFile.createReport(
                getDataFromFile.getData(""), "Report"));
    }

    private String readFromFile(String fileName) {
        try {
            return Files.readString(Path.of(fileName));
        } catch (IOException e) {
            throw new RuntimeException("Can't correctly read data from file " + fileName, e);
        }
    }
}
