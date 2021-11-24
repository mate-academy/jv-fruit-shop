package service;

import core.basesyntax.model.ParseLine;
import service.implement.FileReaderImplement;
import service.implement.InputDataValidatorImp;

import javax.xml.validation.Validator;
import java.util.LinkedList;
import java.util.List;


public interface LineParser {
    InputDataValidator inputValidator = new InputDataValidatorImp();
    public static List<ParseLine> parseLineList = new LinkedList<>();
    default List<ParseLine> lineParcer(List<String> input){
    return parseLineList;
    }
    }

