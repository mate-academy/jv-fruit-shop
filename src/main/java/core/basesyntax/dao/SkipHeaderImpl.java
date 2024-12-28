package core.basesyntax.dao;

import java.util.List;

public class SkipHeaderImpl implements SkipHeader {
    @Override
    public List<String> skip(List<String> file) {
        file.remove(0);
        return file;
    }
}
