package com.common.util;

import java.util.Date;

import org.apache.commons.beanutils.Converter;

public class DateConvert implements Converter {

	public Object convert(Class arg0, Object value) {
		if (value instanceof Date) {
			return value;
		}
		return null;
	}

}