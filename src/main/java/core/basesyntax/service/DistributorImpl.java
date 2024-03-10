package core.basesyntax.service;

import core.basesyntax.service.operationhandlers.AddHandler;
import core.basesyntax.service.operationhandlers.OperationHandler;
import core.basesyntax.service.operationhandlers.ReplaceHandler;
import core.basesyntax.service.operationhandlers.SubtractHandler;
import java.util.HashMap;
import java.util.Map;

public class DistributorImpl implements Distributor {
    public static final Map<String, OperationHandler> HANDLER_MAP = new HashMap<>();
    public static final DataFromNote DATA_FROM_NOTE = new DataFromNoteImpl();
    public static final String INCORRECT_START_OF_STRING = "type";
    public static final int OPERATION_SIGN_INDEX = 0;
    public static final int NAME_OF_PRODUCT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    public DistributorImpl() {
        HANDLER_MAP.put("b", new AddHandler());
        HANDLER_MAP.put("p", new SubtractHandler());
        HANDLER_MAP.put("r", new ReplaceHandler());
        HANDLER_MAP.put("s", new ReplaceHandler());
    }

    @Override
    public void distribute(Map<String, Integer> map, String note) {
        if (note.startsWith(INCORRECT_START_OF_STRING)) {
            return;
        }
        String[] dataFromNote = DATA_FROM_NOTE.getData(note);
        String operationSign = dataFromNote[OPERATION_SIGN_INDEX];
        String nameOfProduct = dataFromNote[NAME_OF_PRODUCT_INDEX];
        int quantity = Integer.parseInt(dataFromNote[QUANTITY_INDEX]);
        OperationHandler handler = HANDLER_MAP.get(operationSign);
        if (handler != null) {
            handler.handle(map, nameOfProduct, quantity);
        } else {
            throw new RuntimeException("Operation type not found");
        }
    }
}
