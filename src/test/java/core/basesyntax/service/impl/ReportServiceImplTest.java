package core.basesyntax.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.ReportService;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("ReportServiceImpl Test")
class ReportServiceImplTest {
    private static final ReportService REPORT_SERVICE = new ReportServiceImpl();
    private static final ProductDao<Product, Integer> DAO = new ProductDaoImpl();
    public static final Product BANANA = Product.BANANA;
    public static final Product APPLE = Product.APPLE;

    @AfterEach
    void tearDown() {
        DAO.clear();
    }

    @DisplayName("Check report with Banana and apple")
    @Order(1)
    @Test
    void createReport_bananaAndApple_ok() {
        DAO.put(BANANA, 20);
        DAO.put(APPLE, 10);
        List<String> expected = List.of(
                "fruit,quantity",
                "banana,20",
                "apple,10");
        List<String> actual = REPORT_SERVICE.createReport();
        assertEquals(expected, actual);
    }

    @DisplayName("Check report with Banana only")
    @Order(2)
    @Test
    void createReport_banana_ok() {
        DAO.put(BANANA, 130);
        List<String> expected = List.of(
                "fruit,quantity",
                "banana,130");
        List<String> actual = REPORT_SERVICE.createReport();
        assertEquals(expected, actual);
    }

    @DisplayName("Check report without any fruit")
    @Order(3)
    @Test
    void createReport_emptyList_ok() {
        List<String> expected = List.of(
                "fruit,quantity");
        List<String> actual = REPORT_SERVICE.createReport();
        assertEquals(expected, actual);
    }
}
