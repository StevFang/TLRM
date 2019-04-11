package com.ddmh.exceptions;

/**
 * @author FBin
 * @version 2019/4/10 13:02
 */
public class TlrException extends RuntimeException {

    public TlrException(){
        super();
    }

    public TlrException(Throwable e){
        super(e);
    }

    public TlrException(String message){
        super(message);
    }

    public TlrException(String message, Throwable e){
        super(message, e);
    }

}
