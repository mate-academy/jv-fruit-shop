package core.basesyntax.service;

import core.basesyntax.model.FruitNegotiation;
import java.util.List;

public interface NegotiationParserService {
    public List<FruitNegotiation> createNegotiation(List<String> records);
}
