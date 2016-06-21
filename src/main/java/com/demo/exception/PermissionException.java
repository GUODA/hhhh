package com.demo.exception;

/**
 * Created with IntelliJ IDEA.
 * User: Eleph_Tr
 * Date: 13-9-12
 * Time: 下午8:27
 * To change this template use File | Settings | File Templates.
 */
public class PermissionException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public PermissionException() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     */
    public PermissionException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param cause
     */
    public PermissionException(Throwable cause) {
        super(cause);
        // TODO Auto-generated constructor stub
    }

    /**
     * @param message
     * @param cause
     */
    public PermissionException(String message, Throwable cause) {
        super(message, cause);
        // TODO Auto-generated constructor stub
    }
}
