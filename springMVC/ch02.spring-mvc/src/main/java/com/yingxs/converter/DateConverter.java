package com.yingxs.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;


/**
 * 	自定义类型转换器
 * 	字符串类型->Date类型
 * @author admin
 *
 */
public class DateConverter implements Converter<String,Date> {

	@Override
	public Date convert(String birth) {
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		
		try {
			return sdf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	
}
