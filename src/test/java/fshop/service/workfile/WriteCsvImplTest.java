package fshop.service.workfile;

import static junit.framework.TestCase.assertEquals;

import fshop.db.FoodDao;
import fshop.db.FoodDaoImpl;
import fshop.model.Food;
import java.util.Map;
import org.junit.Test;

public class WriteCsvImplTest {
    @Test (expected = NullPointerException.class)
    public void createObject_null() {
        new WriteCsvImpl(null);
    }
    
    @Test (expected = NullPointerException.class)
    public void setFoodDao_null() {
        new WriteCsvImpl("report.csv").setFoodDao(null);
    }

    @Test
    public void write_test1() {
        ReadCsv readCsvFirst = new ReadCsvImpl("file.csv");
        FoodDao foodDaoFirst = new FoodDaoImpl(readCsvFirst);
        foodDaoFirst.addAll();
        foodDaoFirst.updateAll();
        WriteCsv writeCsvFirst = new WriteCsvImpl("report.csv");
        writeCsvFirst.setFoodDao(foodDaoFirst);
        Map<Food, Integer> actual = writeCsvFirst.write();

        assertEquals(2, actual.size());
    }

    @Test
    public void write_test2() {
        ReadCsv readCsvSecond = new ReadCsvImpl("file2.csv");
        FoodDao foodDaoSecond = new FoodDaoImpl(readCsvSecond);
        foodDaoSecond.addAll();
        foodDaoSecond.updateAll();
        WriteCsv writeCsvSecond = new WriteCsvImpl("report.csv");
        writeCsvSecond.setFoodDao(foodDaoSecond);
        Map<Food, Integer> actual = writeCsvSecond.write();

        assertEquals(2, actual.size());
    }
}
