package parsers;

import dto.SupplierOrder;
import java.time.LocalDate;
import java.util.List;

public class SupplierOrderParser implements OrderParser<SupplierOrder> {
    @Override
    public SupplierOrder parse(List<String> data) {
        SupplierOrder productSupplier = new SupplierOrder();
        productSupplier.setProductName(data.get(1));
        productSupplier.setQuantity(Integer.parseInt(data.get(2)));
        productSupplier.setDate(LocalDate.parse(data.get(3), FORMATTER));
        return productSupplier;
    }
}
