package com.tgraph.renderer.exception;

/**
 * Exception to throw when we are attempting to redifine a screen.
 * 
 * @author Suvabrata Chowdhury
 */
public class ScreenDefinitionException extends Exception{
    public ScreenDefinitionException(String msg) {
        super(msg);
    }
}
