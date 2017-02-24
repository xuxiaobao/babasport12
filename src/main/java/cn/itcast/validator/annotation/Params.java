package cn.itcast.validator.annotation;

import cn.itcast.validator.Validators;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;



@Retention(RetentionPolicy.RUNTIME)
public @interface Params {
	String name();
	Class<?> type() default String.class;
	Class<?> elementType() default Object.class;
	String validator() default Validators.NONE;
	/*
	 * 输入最大值
	 */
	String maxValue() default Validators.NONE;
	/*
	 * 输入最小值
	 */
	String minValue() default Validators.NONE;
	/*
	 * 输入最大长度
	 */
	String maxLength() default Validators.NONE;
	/*
	 * 输入最小长度
	 */
	String minLength() default Validators.NONE;
	/*
	 *输入正则
	 */
	String regPattern() default Validators.NONE;
	
}
