package core.basesyntax.handler;

import java.util.List;

public interface FileProcessor {

    List<Request> read(String fileName);

    String write(List<String> data);

}
