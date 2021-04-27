package fshop.service.workfile;

import static junit.framework.TestCase.assertEquals;

import fshop.db.FoodDao;
import fshop.db.FoodDaoImpl;
import fshop.model.Food;
import java.util.List;
import java.util.Map;
import org.junit.Test;

public class WriteCsvImplTest {
    @Test (expected = NullPointerException.class)
    public void createObject_null() {
        new WriteCsvImpl(null);
    }

    @Test
    public void write_test1() {
        ReadCsv readCsv = new ReadCsvImpl();
        WriteCsv writeCsvFirst = new WriteCsvImpl("report.csv");

        FoodDao foodDaoFirst = new FoodDaoImpl();
        List<String> fileLinesFirst = readCsv.read("file.csv");

        foodDaoFirst.addAll(fileLinesFirst);
        foodDaoFirst.updateAll(fileLinesFirst);
        Map<Food, Integer> actual = writeCsvFirst.write(foodDaoFirst.getDataOfBalance());

        assertEquals(2, actual.size());
    }

    @Test
    public void write_test2() {
        ReadCsv readCsv = new ReadCsvImpl();
        WriteCsv writeCsvSecond = new WriteCsvImpl("report.csv");

        FoodDao foodDaoSecond = new FoodDaoImpl();
        List<String> fileLinesSecond = readCsv.read("file2.csv");

        foodDaoSecond.addAll(fileLinesSecond);
        foodDaoSecond.updateAll(fileLinesSecond);
        Map<Food, Integer> actual = writeCsvSecond.write(foodDaoSecond.getDataOfBalance());

        assertEquals(2, actual.size());
    }
}
