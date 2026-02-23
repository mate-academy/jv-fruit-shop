package core.basesyntax;

import static org.junit.jupiter.api.Assertions.assertTrue;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import core.basesyntax.service.impl.ReportGeneratorImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ReportGeneratorImplTest {
    private FruitDao fruitDao;
    private ReportGenerator reportGenerator;

    @BeforeEach
    void setUp() {
        fruitDao = new FruitDaoImpl();
        reportGenerator = new ReportGeneratorImpl(fruitDao);
        Storage.clear(); 
        
    }

    @Test
    void getReport_isOk() {
        fruitDao.add("banana", 20);
        fruitDao.add("apple", 10);

        String report = reportGenerator.getReport();

        assertTrue(report.contains("fruit,quantity"));
        assertTrue(report.contains("banana,20"));
        assertTrue(report.contains("apple,10"));
    }
}
