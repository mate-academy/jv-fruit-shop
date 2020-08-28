package core.basesyntax.servise;

import core.basesyntax.ProductsDto;
import core.basesyntax.operations.BuyOperation;
import core.basesyntax.operations.FruitOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;

import java.util.HashMap;
import java.util.Map;

public class FruitService {
    private static final Map<String, FruitOperation> operationMap = new HashMap<>();
    static {
        operationMap.put("s", new SupplyOperation());
        operationMap.put("b", new BuyOperation());
        operationMap.put("r", new ReturnOperation());
    }

    public void convert(ProductsDto productsDto) {
        FruitOperation operation = operationMap.get(productsDto.getOperation());
        operation.fruitOperation(productsDto);
    }

//    void validateProduct(List<ProductsDto> products) {
//        for (ProductsDto prod : products) {
//            switch (prod.getOperation()) {
//                case "s":
//                    addProduct(prod);
//                    break;
//                case "r":
//                    returnProduct(prod);
//                    break;
//                case "b":
//                    removeProduct(prod);
//                    break;
//            }
//        }
//    }
//
//    void addProduct(ProductsDto product) {
//        for (int i = 0; i < product.getQuantity(); i++) {
//            Fruit fruit = new Fruit(product.getName(), product.getExpirationDate());
//            Storege.fruits.add(fruit);
//        }
//    }
//
//    void removeProduct(ProductsDto product) {
//        for (int i = 0; i < product.getQuantity(); i++) {
//            Fruit fruit = new Fruit(product.getName(), product.getExpirationDate());
//            Storege.fruits.remove(fruit);
//        }
//    }
//
//    void returnProduct(ProductsDto product) {
//        for (int i = 0; i < product.getQuantity(); i++) {
//            Fruit fruit = new Fruit(product.getName(), product.getExpirationDate());
//            Storege.fruits.add(fruit);
//        }
//    }
}
