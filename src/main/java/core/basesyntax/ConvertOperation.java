package core.basesyntax;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvDataTypeMismatchException;

public class ConvertOperation<T, I> extends AbstractBeanField<T, I> {
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";

    public ConvertOperation() {
    }

    @Override
    protected Object convert(String value) throws CsvDataTypeMismatchException {
        if (value.isEmpty()) {
            return null;
        }
        switch (value) {
            case SUPPLY:
                return Operation.SUPPLY;
            case BUY:
                return Operation.BUY;
            case RETURN:
                return Operation.RETURN;
            default:
                throw new CsvDataTypeMismatchException("Wrong operation format");
        }
    }
}
