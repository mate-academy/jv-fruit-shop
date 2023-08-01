package core.basesyntax.serviceimpl;

import core.basesyntax.service.DataParser;

public class DataParsesImpl implements DataParser {
    @Override
    public String[] getParsedData(String data) {
        String essentialData = data.substring(data.indexOf("\n") + 1);
        return essentialData.split("\n");
    }
}
