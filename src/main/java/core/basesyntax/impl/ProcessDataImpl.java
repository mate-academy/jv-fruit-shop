package core.basesyntax.impl;

import core.basesyntax.service.ProcessData;
import core.basesyntax.transactor.FruitTransaction;
import core.basesyntax.transactor.Operation;
import java.util.List;
import java.util.stream.Stream;

public class ProcessDataImpl implements ProcessData {

    @Override
    public List<FruitTransaction> process(String inputData) {
        String[] records = inputData.split(System.lineSeparator());
        return Stream.of(records).skip(1)
                .map(this::convertDataToTransaction).toList();
    }

    private Operation getOperation(String code) {
        return Stream.of(Operation.values())
                .filter(o -> o.getCode().equals(code))
                .findFirst().orElseThrow(() -> new RuntimeException(
                        "No operation following code: " + code));
    }

    private FruitTransaction convertDataToTransaction(String inputDataLine) {
        String[] data = inputDataLine.split(",");
        return new FruitTransaction(getOperation(data[0].trim()),
                data[1].trim(), Integer.parseInt(data[2].trim()));
    }
}
