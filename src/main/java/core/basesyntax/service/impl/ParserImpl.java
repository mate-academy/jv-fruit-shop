package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperation;
import core.basesyntax.model.Instruction;
import core.basesyntax.service.Parser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ParserImpl implements Parser {
    @Override
    public List<Instruction> parse(List<String[]> lines) {
        List<Instruction> commands = new ArrayList<>();
        for (String[] line : lines) {
            if (line.length != 3) {
                throw new RuntimeException("Can't parse information from " + Arrays.toString(line));
            }
            Instruction instruction = new Instruction(
                    FruitOperation.getFromCode(line[0]),
                    line[1],
                    Integer.parseInt(line[2])
            );
            commands.add(instruction);
        }
        return commands;
    }
}
