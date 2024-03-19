package core.basesyntax.serviceImpl;

import core.basesyntax.model.FruitsTransaction;
import core.basesyntax.exceptions.InvalidDataTypeException;
import core.basesyntax.service.DataParseService;

import java.util.List;
import java.util.stream.Collectors;

public class DataParseServiceImpl implements DataParseService {

    @Override
    public List<FruitsTransaction> getTransactionList(List<String> data) {
        return data.stream()
                .skip(1)
                .map(this::parseTransaction)
                .collect(Collectors.toList());
    }

    private FruitsTransaction parseTransaction(String data) {
        String[] dataArray = data.split(",");
        if (dataArray.length != 3) {
            throw new InvalidDataTypeException("Invalid transaction data format");
        }

        String operationCode = dataArray[0];
        FruitsTransaction.Operation operation = null;
        for (FruitsTransaction.Operation op : FruitsTransaction.Operation.values()) {
            if (op.getCode().equals(operationCode)) {
                operation = op;
                break;
            }
        }
        if (operation == null) {
            throw new InvalidDataTypeException("Invalid operation code: " + operationCode);
        }

        String name = dataArray[1];
        int quantity = Integer.parseInt(dataArray[2]);
        return new FruitsTransaction(operation, name, quantity);
    }
}
//переводимо ліст стрінгів у об`єкт List<FruitsTransaction>
// у вигляді дія.ім'я .значення
