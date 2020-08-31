package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class ReportServiceTest {
    private ReportService reportService = new ReportService();
    private Storage storage = new Storage();
    private TypesOfFruitsInStorage typesOfFruitsInStorage = new TypesOfFruitsInStorage();

    @Test
    public void toGetResultOk() {
        LocalDate localDateApple = LocalDate.of(2020, 4, 13);
        FruitPackage fruitPostApple = new FruitPackage("apple", 4, localDateApple);
        FruitPackage fruitPostLime = new FruitPackage("lime", 12, localDateApple);
        FruitPackage fruitPostLime2 = new FruitPackage("lime", 11, localDateApple);
        storage.getFruitPackages().add(fruitPostApple);
        storage.getFruitPackages().add(fruitPostLime);
        storage.getFruitPackages().add(fruitPostLime2);
        Map<String, String> expectedResult = new HashMap<>();
        expectedResult.put("apple", "4");
        expectedResult.put("lime", "23");

        Assert.assertEquals(expectedResult.size(),
                reportService.toGetReport(storage,
                        typesOfFruitsInStorage.getTypesOfFruits(storage)).size());
        Assert.assertEquals(expectedResult.get("apple"),
                reportService.toGetReport(storage,
                        typesOfFruitsInStorage.getTypesOfFruits(storage)).get("apple"));
        Assert.assertEquals(expectedResult.get("lime"),
                reportService.toGetReport(storage,
                        typesOfFruitsInStorage.getTypesOfFruits(storage)).get("lime"));
    }
}
