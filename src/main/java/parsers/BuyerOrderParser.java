package parsers;

import dto.BuyerOrder;
import java.time.LocalDate;
import java.util.List;

public class BuyerOrderParser implements OrderParser<BuyerOrder> {
    @Override
    public BuyerOrder parse(List<String> data) {
        BuyerOrder buyerOrder = new BuyerOrder();
        buyerOrder.setProductName(data.get(1));
        buyerOrder.setQuantity(Integer.parseInt(data.get(2)));
        buyerOrder.setDate(LocalDate.parse(data.get(3), FORMATTER));
        return buyerOrder;
    }
}
