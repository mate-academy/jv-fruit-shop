package servise;

import dto.Storage;
import java.util.List;

public interface Parser {
    List<Storage> parse(List<String> inputData);
}
