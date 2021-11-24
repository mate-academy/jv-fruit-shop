package service;

import core.basesyntax.model.ParseLine;
import java.util.LinkedList;
import java.util.List;
import service.implement.InputDataValidatorImp;

public interface LineParser {
    InputDataValidator inputValidator = new InputDataValidatorImp();
    List<ParseLine> parseLineList = new LinkedList<>();

    List<ParseLine> lineParcer(List<String> input);
}

