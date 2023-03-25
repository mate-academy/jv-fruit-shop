package core.basesyntax.service;

import java.util.List;

public interface RecordingService {
    void writeIntoFile(List<String> listData, String path);
}
