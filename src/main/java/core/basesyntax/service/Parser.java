package core.basesyntax.service;

import core.basesyntax.model.Instruction;
import java.util.List;

public interface Parser {
    List<Instruction> parse(List<String[]> lines);
}
