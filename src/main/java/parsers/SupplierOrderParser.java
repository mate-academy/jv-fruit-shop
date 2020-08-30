package parsers;

import dto.SupplierOrder;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class SupplierOrderParser implements OrderParser<SupplierOrder> {
    @Override
    public SupplierOrder parse(List<String> data) {
        SupplierOrder productSupplier = new SupplierOrder();
        try {
            productSupplier.setProductName(data.get(1));
            productSupplier.setQuantity(Integer.parseInt(data.get(2)));
            productSupplier.setDate(LocalDate.parse(data.get(3), FORMATTER));
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new RuntimeException("Wrong input order/format!");
        }
        return productSupplier;
    }
}
