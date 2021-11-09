package core.basesyntax.service;

import core.basesyntax.dao.ResourcesDaoImpl;

public class StorageServiceImpl implements StorageService {
    private static final int OPERATION_NAME_INDEX = 0;
    private static final int PRODUCT_NAME_INDEX = 1;
    private static final int OPERATION_AMOUNT_INDEX = 2;
    private OperationStrategy operation = new OperationStrategy();
    private ResourcesDaoImpl inputFile = new ResourcesDaoImpl();
    private Validator validator = new Validator();

    @Override
    public void updateProductsAmountInStorage(String filePath) {
        inputFile.readFromFile(filePath).stream()
                 .map(n -> n.split(","))
                 .filter(validator)
                 .forEach(n -> operation.getOperationByName(n[OPERATION_NAME_INDEX])
                         .applyOperation(n[PRODUCT_NAME_INDEX],
                                 Integer.parseInt(n[OPERATION_AMOUNT_INDEX])));
    }
}
