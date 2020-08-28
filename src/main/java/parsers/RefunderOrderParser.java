package parsers;

import dto.RefunderOrder;
import java.time.LocalDate;
import java.util.List;

public class RefunderOrderParser implements OrderParser<RefunderOrder> {
    @Override
    public RefunderOrder parse(List<String> data) {
        RefunderOrder refunderOrder = new RefunderOrder();
        refunderOrder.setProductName(data.get(1));
        refunderOrder.setQuantity(Integer.parseInt(data.get(2)));
        refunderOrder.setDate(LocalDate.parse(data.get(3), FORMATTER));
        return refunderOrder;
    }
}
