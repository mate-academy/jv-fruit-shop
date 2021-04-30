package com.companyname.fruitshop.service.impl;

public class InvalidDataFormatException extends RuntimeException {
    public InvalidDataFormatException(String message) {
        System.out.println(message);
    }
}
