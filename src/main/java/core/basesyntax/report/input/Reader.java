package core.basesyntax.report.input;

import java.util.List;

public interface Reader {
    List<String> read(String srcPath);
}
