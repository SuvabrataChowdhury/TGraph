package com.tgraph.scene.definition.point.exceptions;

/**
 * Exception for any invalid operation on a point.
 * 
 * @author Suvabrata Chowdhury
 */
public class InvalidPointOperationException extends Exception{

    public InvalidPointOperationException() {
        super();
    }

    public InvalidPointOperationException(String msg) {
        super(msg);
    }
}
