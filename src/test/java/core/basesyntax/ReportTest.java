package core.basesyntax;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReportTest {

    @Test
    public void createCorrectReportTest() {
        int randomAmount = (int) (Math.random() * 100);
        DateAndQuantity dateAndQuantity = new DateAndQuantity(LocalDate.now(), randomAmount);
        List<DateAndQuantity> specificFruitList = new ArrayList<>();
        specificFruitList.add(dateAndQuantity);
        ProductCalculator.STORAGE.put("banana", specificFruitList);
        Report report = new Report();
        String actual = report.getReport();
        String expected = "fruit,quantity\nbanana," + String.valueOf(randomAmount) + "\n";
        System.out.println(expected);
        Assert.assertEquals(actual, expected);
    }
}
