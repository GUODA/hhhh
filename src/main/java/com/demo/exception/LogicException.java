package com.demo.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Eleph_Tr
 * Date: 13-8-24
 * Time: 下午4:43
 * To change this template use File | Settings | File Templates.
 */
public class LogicException extends Exception {
    private static final long serialVersionUID = 1L;

    public LogicException() {
        // TODO Auto-generated constructor stub
    }

    public LogicException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    public LogicException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    public LogicException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
}
