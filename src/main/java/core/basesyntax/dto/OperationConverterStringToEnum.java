package core.basesyntax.dto;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.exceptions.CsvConstraintViolationException;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import core.basesyntax.model.Operation;

public class OperationConverterStringToEnum<T,I> extends AbstractBeanField<T,I> {
    @Override
    protected Object convert(String s) throws CsvDataTypeMismatchException,
            CsvConstraintViolationException {
        return Operation.codeOf(s);
    }
}

