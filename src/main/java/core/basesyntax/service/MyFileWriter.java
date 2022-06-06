package core.basesyntax.service;

import java.io.File;
import java.util.List;

public interface MyFileWriter {
    File writeReport(List<String> info);
}
