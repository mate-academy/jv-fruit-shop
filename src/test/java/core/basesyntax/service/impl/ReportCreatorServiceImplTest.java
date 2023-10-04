package core.basesyntax.service.impl;

import static core.basesyntax.model.Product.APPLE;
import static core.basesyntax.model.Product.BANANA;
import static org.junit.jupiter.api.Assertions.assertEquals;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.ProductDaoImpl;
import core.basesyntax.model.Product;
import core.basesyntax.service.ReportCreatorService;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

@DisplayName("ReportServiceImpl Test")
class ReportCreatorServiceImplTest {
    private static ReportCreatorService reportCreatorService;
    private final ProductDao<Product, Integer> dao = new ProductDaoImpl();

    @BeforeAll
    static void beforeAll() {
        reportCreatorService = new ReportCreatorServiceImpl(new ProductDaoImpl());
    }

    @AfterEach
    void tearDown() {
        dao.clear();
    }

    @DisplayName("Check report with Banana and apple")
    @Order(1)
    @Test
    void createReport_bananaAndApple_ok() {
        dao.put(BANANA, 20);
        dao.put(APPLE, 10);
        List<String> expected = List.of(
                "fruit,quantity",
                "banana,20",
                "apple,10");
        List<String> actual = reportCreatorService.createReport();
        assertEquals(expected, actual);
    }

    @DisplayName("Check report with Banana only")
    @Order(2)
    @Test
    void createReport_banana_ok() {
        dao.put(BANANA, 130);
        List<String> expected = List.of(
                "fruit,quantity",
                "banana,130");
        List<String> actual = reportCreatorService.createReport();
        assertEquals(expected, actual);
    }

    @DisplayName("Check report without any fruit")
    @Order(3)
    @Test
    void createReport_emptyList_ok() {
        List<String> expected = List.of(
                "fruit,quantity");
        List<String> actual = reportCreatorService.createReport();
        assertEquals(expected, actual);
    }
}
