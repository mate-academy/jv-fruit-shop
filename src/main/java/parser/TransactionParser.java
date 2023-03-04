package parser;

import java.util.List;

public interface TransactionParser {
    List parse(List<String> lines);
}
