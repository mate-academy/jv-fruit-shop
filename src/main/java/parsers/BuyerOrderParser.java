package parsers;

import dto.BuyerOrder;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

public class BuyerOrderParser implements OrderParser<BuyerOrder> {
    @Override
    public BuyerOrder parse(List<String> data) {
        BuyerOrder buyerOrder = new BuyerOrder();
        try {
            buyerOrder.setProductName(data.get(1));
            buyerOrder.setQuantity(Integer.parseInt(data.get(2)));
            buyerOrder.setDate(LocalDate.parse(data.get(3), FORMATTER));
        } catch (NumberFormatException | DateTimeParseException e) {
            throw new RuntimeException("Wrong input order/format!");
        }
        return buyerOrder;
    }
}
