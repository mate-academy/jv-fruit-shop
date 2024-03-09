package core.basesyntax.service;

import java.util.Map;

public class DistributorImpl implements Distributor {
    public static final int OPERATION_SIGN_INDEX = 0;
    public static final int NAME_OF_PRODUCT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public void distribute(Map<String, Integer> map, String[] note) {
        String operationSign = note[OPERATION_SIGN_INDEX];
        String nameOfProduct = note[NAME_OF_PRODUCT_INDEX];
        int quantity = Integer.parseInt(note[QUANTITY_INDEX]);

        switch (operationSign) {
            case "b" -> map.put(nameOfProduct, quantity);
            case "p" -> map.replace(nameOfProduct, map.get(nameOfProduct) - quantity);
            case "r", "s" -> map.replace(nameOfProduct, map.get(nameOfProduct) + quantity);
            default -> throw new RuntimeException("Operation type not found");
        }
    }
}
