
/**
 * All copyright reserved by NewHeight LTD.
 * 
 */

package com.common.exception;


import java.util.List;


/**
 * BusinessException
 * 
 * @author evan
 * @version 0.1, 2008-3-9
 * @since   JDK1.6
 */
public class BusinessException extends BaseException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5566121117338870812L;

	public BusinessException() {
		super();
	}

	public BusinessException(String errCode, List<String> params) {
		super(errCode, params);
	}
	
	public BusinessException(String errCode, String[] params) {
		super(errCode, params);
	}

	public BusinessException(String errCode, String message) {
		super(errCode, message);
	}

	public BusinessException(String errCode) {
		super(errCode);
	}
	

}
