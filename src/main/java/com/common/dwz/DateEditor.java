package com.common.dwz;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

public class DateEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {

		if (!StringUtils.hasText(text)) {
			setValue(null);
		} else {
			String fomat="yyyy-MM-dd HH:mm:ss";
			if(text.length()==10){
				fomat="yyyy-MM-dd";
			}
			SimpleDateFormat dateFormat = new SimpleDateFormat(fomat); 
			try {
				setValue(dateFormat.parse(text));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getAsText() {

		return getValue().toString();
	}
}
