package core.basesyntax.service;

import core.basesyntax.model.Record;

public interface ToRecordParser {
    Record parse(String string);
}
