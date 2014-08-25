package org.tmf.dsmapi.common.exceptions;

public class UnknownResourceException extends FunctionalException {
    
    public UnknownResourceException(ExceptionType type) {
        super(type);
    }
    
    public UnknownResourceException(ExceptionType type, String message) {
        super(type, message);
    }     
    
}
