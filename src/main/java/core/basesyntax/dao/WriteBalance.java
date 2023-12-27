package core.basesyntax.dao;

import java.io.IOException;

public interface WriteBalance {
    public boolean write(String report) throws IOException;
}
