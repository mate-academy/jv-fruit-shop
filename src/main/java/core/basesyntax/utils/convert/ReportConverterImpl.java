package core.basesyntax.utils.convert;

import core.basesyntax.utils.transaction.FruitTransaction;
import java.util.List;

public class ReportConverterImpl implements ReportConverter {
    private final ReportConverter converter;

    public ReportConverterImpl(ReportConverter converter) {
        this.converter = converter;
    }

    public List<FruitTransaction> convert() {
        return converter.convert();
    }
}
