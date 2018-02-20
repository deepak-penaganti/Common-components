package com.keystone.common.exception.types;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.sql.SQLException;

/**
 * This exception is thrown for DB exceptions, Message Broker calls. This class defines a few typical
 * error types to help the developer find the error cause.
 */
public class DataAccessException extends Exception {
	private static final long serialVersionUID = 1L;

	private String mstrCause;

	private Exception mobjPrevException = null;

	public static final String DB_EXCEPTION = "Database Exception";
	
	public static final String MESSAGE_BROKER_CALL_EXCEPTION = "Message Broker Exception";


	public DataAccessException() {
	}

	public DataAccessException(String message) {
		super(message);
	}

	public DataAccessException(String message, Exception exception) {
		super(message);
		resolveCause(exception);
	}

	public DataAccessException(Exception exception) {
		super(exception.toString());
		resolveCause(exception);
	}

	public void printStackTrace() {
		super.printStackTrace();
		if (mobjPrevException != null)
			mobjPrevException.printStackTrace();
	}

	public void printStackTrace(PrintStream apsObj) {
		super.printStackTrace(apsObj);
		if (mobjPrevException != null)
			mobjPrevException.printStackTrace(apsObj);
	}

	public void printStackTrace(PrintWriter apwObj) {
		super.printStackTrace(apwObj);
		if (mobjPrevException != null)
			mobjPrevException.printStackTrace(apwObj);
	}

	public String getErrorCause() {
		return mstrCause;
	}

	private void resolveCause(Exception exception) {
		this.mobjPrevException = exception;

		if (exception instanceof SQLException) {
			this.mstrCause = DB_EXCEPTION;
		} else if (exception instanceof IOException) {
			this.mstrCause = MESSAGE_BROKER_CALL_EXCEPTION;
		}else {
			this.mstrCause = exception.toString();
		}
	}

	
}

