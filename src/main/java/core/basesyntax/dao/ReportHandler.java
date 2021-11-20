package core.basesyntax.dao;

import java.util.List;

public interface ReportHandler {

    List<String> read(String source);

    boolean write(String fileName, String data);
}
