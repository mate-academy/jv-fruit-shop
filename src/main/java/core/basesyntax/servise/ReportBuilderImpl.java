package core.basesyntax.servise;

import core.basesyntax.model.Fruit;
import core.basesyntax.servise.exception.InvalidInputDataException;
import core.basesyntax.servise.inrterfase.ReportBuilder;
import java.util.ArrayList;
import java.util.List;

public class ReportBuilderImpl implements ReportBuilder {
    private static final String COMMA = ",";
    private static final int INDEX_OF_TYPE = 0;
    private static final int UNNECESSARY_LINE = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_AMOUNT = 2;
    private static final int NUMBER_OF_TYPES_IN_THE_ENTERED_DATA = 3;

    @Override
    public List<FruitRecordDto> getReport(List<String> report) {
        List<FruitRecordDto> fruitRecordDtos = new ArrayList<>();
        report.remove(UNNECESSARY_LINE);
        for (String line : report) {
            String[] data = line.split(COMMA);
            validatorOfData(data);
            Operation operation = Operation.getOperationType(data[INDEX_OF_TYPE].trim());

            FruitRecordDto fruitFromReport = new FruitRecordDto(operation,
                    new Fruit(data[INDEX_OF_FRUIT]), Integer.parseInt(data[INDEX_OF_AMOUNT]));
            fruitRecordDtos.add(fruitFromReport);
        }
        return fruitRecordDtos;
    }

    private boolean validatorOfData(String[] data) {
        try {
            if (data.length != NUMBER_OF_TYPES_IN_THE_ENTERED_DATA
                    || Integer.parseInt(data[INDEX_OF_AMOUNT]) < 0) {
                throw new InvalidInputDataException("Input data is incorrect!"
                        + " Please check your file and try again.");
            }
        } catch (NumberFormatException e) {
            throw new NumberFormatException("You must enter number in format [0-9]!"
                    + " Please check your file and try again.");
        }
        return true;
    }
}
