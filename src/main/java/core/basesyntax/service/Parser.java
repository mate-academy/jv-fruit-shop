package core.basesyntax.service;

import core.basesyntax.dto.Transaction;

import java.util.List;

public interface Parser {
    Transaction parse(String line);
}
