package com.xingxing.privateRecord.util;

import java.io.PrintStream;
import java.io.PrintWriter;

public class PrecordException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -186627700388484188L;

	private Throwable cause = null;
	
	public PrecordException() {}

	public PrecordException(String message, Throwable cause) {
		super(message);
		this.cause = cause;
	}

	public PrecordException(String message) {
		super(message);
	}

	public PrecordException(Throwable cause) {
		super();
		this.cause = cause;
	}

	@Override
	public String getMessage() {
		return super.getMessage();
	}

	@Override
	public synchronized Throwable getCause() {
		return cause;
	}

	@Override
	public String toString() {
		if(cause == null) {
			return super.toString();
		}else {
			return super.toString()+"precordException:"+cause.toString();
		}
	}

	@Override
	public void printStackTrace() {
		super.printStackTrace();
		if(cause !=null) {
			System.err.println("precordException:");
			cause.printStackTrace();
		}
	}

	@Override
	public void printStackTrace(PrintStream s) {
		super.printStackTrace(s);
		if(cause != null) {
			s.print("precordException:");
			cause.printStackTrace(s);
		}
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		super.printStackTrace(s);
		if(cause != null) {
			s.print("precordException:");
			cause.printStackTrace(s);
		}
	}

	
}
