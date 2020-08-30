package parsers;

import dto.BuyerOrder;
import dto.RefunderOrder;
import dto.SupplierOrder;
import org.junit.Test;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class OrderParserTest {
    SupplierOrder supplierOrder = new SupplierOrder();
    BuyerOrder buyerOrder = new BuyerOrder();
    RefunderOrder refunderOrder = new RefunderOrder();

    @Test(expected = DateTimeParseException.class)
    public void incorrectDateInputTest() {
        supplierOrder.setDate(LocalDate.parse("blablabla"));
        buyerOrder.setDate(LocalDate.parse("blablabla"));
        refunderOrder.setDate(LocalDate.parse("blablabla"));
    }

    @Test(expected = NumberFormatException.class)
    public void incorrectAmountInputTest() {
        supplierOrder.setQuantity(Integer.parseInt("blablabla"));
        buyerOrder.setQuantity(Integer.parseInt("blablabla"));
        refunderOrder.setQuantity(Integer.parseInt("blablabla"));
    }
}
