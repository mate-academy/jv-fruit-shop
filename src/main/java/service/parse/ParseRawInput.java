package service.parse;

import java.util.List;

public interface ParseRawInput {
    List<String[]> parse(List<String> inputData);
}
