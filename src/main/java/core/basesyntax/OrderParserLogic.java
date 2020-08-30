package core.basesyntax;

import dto.AbstractOrder;
import dto.BuyerOrder;
import dto.RefunderOrder;
import dto.SupplierOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import parsers.BuyerOrderParser;
import parsers.OrderParser;
import parsers.RefunderOrderParser;
import parsers.SupplierOrderParser;

public class OrderParserLogic {

    public static final Map<String, OrderParser> command = new HashMap<>();

    {
        command.put("b", new BuyerOrderParser());
        command.put("r", new RefunderOrderParser());
        command.put("s", new SupplierOrderParser());
    }

    public void parseToStorage(List<String> line) {
        AbstractOrder order = command.get(line.get(0)).parse(line);
        ProductCalculator calculator = new ProductCalculator();

        if (order instanceof SupplierOrder) {
            calculator.productToStorage((SupplierOrder) order);
        }
        if (order instanceof BuyerOrder) {
            calculator.productToStorage((BuyerOrder) order);
        }
        if (order instanceof RefunderOrder) {
            calculator.productToStorage((RefunderOrder) order);
        }
    }
}
