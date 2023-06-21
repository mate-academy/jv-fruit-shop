package core.basesyntax.service.serviceimpl;

import core.basesyntax.model.ItemOperation;
import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;
import java.util.List;
import java.util.stream.Collectors;

public class OperationServiceImpl implements OperationService {
    private static final String SEPARATOR = ",";
    private static final int TITLE_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int ITEM_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<ItemOperation> createOperationList(List<String> data) {
        return data.subList(TITLE_INDEX, data.size()).stream()
                .map(this::setOperation)
                .collect(Collectors.toList());
    }

    private ItemOperation setOperation(String record) {
        String[] line = record.split(SEPARATOR);
        return new ItemOperation(Operation.fromValue(line[OPERATION_INDEX]),
                line[ITEM_INDEX], Integer.parseInt(line[QUANTITY_INDEX]));
    }
}
