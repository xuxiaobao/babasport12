package cn.itcast.validator;


import cn.itcast.validator.annotation.Params;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorFactory {

	public static boolean validate(Object object, Params params) {

		if (Validators.NONE.equals(params.validator())) {
			if (object == null) {
				return true;
			}
		}else {
			if (object == null) {
				return false;
			}
		}
		if (object instanceof Set<?>) {
			for(Object value : (Set<?>)object) {
				return simpleTypeValidator(value, params);
			}
		}else {
			
			return simpleTypeValidator(object, params);
		}
		return true;
	}

	private static boolean simpleTypeValidator(Object object, Params params) {
		if (Validators.NONE.equals(params.validator())) {
			if (object == null) {
				return true;
			}
		}
		if (!Validators.NONE.equals(params.maxValue())) {
			if (object instanceof Long) {
				if (!validatorLongMax((Long)object, Long.parseLong(params.maxValue()))) {
					return false;
				}
			}
			if (object instanceof Integer) {
				if (!validatorIntMax((Integer)object, Long.parseLong(params.maxValue()))) {
					return false;
				}
			}
			if (object instanceof Double) {
				if (!validatorDoubleMax((Double)object, Long.parseLong(params.maxValue()))) {
					return false;
				}
			}
		}
		if (!Validators.NONE.equals(params.minValue())) {
			if (object instanceof Long) {
				if (!validatorLongMin((Long)object, Long.parseLong(params.minValue()))) {
					return false;
				}
			}
			if (object instanceof Integer) {
				if (!validatorIntMin((Integer)object, Long.parseLong(params.minValue()))) {
					return false;
				}
			}
			if (object instanceof Double) {
				if (!validatorDoubleMin((Double)object, Long.parseLong(params.minValue()))) {
					return false;
				}
			}
		}
		if (!Validators.NONE.equals(params.maxLength())) {
			if (!validatorLengthMax((String)object, Integer.parseInt(params.maxLength()))) {
				return false;
			}
		}
		if (!Validators.NONE.equals(params.minLength())) {
			if (!validatorLengthMin((String)object, Integer.parseInt(params.minLength()))) {
				return false;
			} 
		}
		if (!Validators.NONE.equals(params.regPattern())) {
			if (!validatorRegPattern((String)object, params.regPattern())) {
				return false;
			}
		}
		return true;
	}



	private static boolean validatorDoubleMin(Double object, long minValue) {
		if (object != null) {
			if (object < minValue) {
				return false;
			}
		}
		return true;
	}


	private static boolean validatorIntMin(Integer object, long minValue) {
		if (object != null) {
			if (object < minValue) {
				return false;
			}
		}
		return true;
	}


	private static boolean validatorDoubleMax(Double object, long maxValue) {
		if (object != null) {
			if (object > maxValue) {
				return false;
			}
		}
		return true;
	}


	private static boolean validatorIntMax(Integer object, long maxValue) {
		if (object != null) {
			if (object > maxValue) {
				return false;
			}
		}
		return true;
	}


	private static boolean validatorRegPattern(String value, String regPattern) {
		if (value != null) {
			Pattern pattern = Pattern.compile(regPattern);
			Matcher matcher = pattern.matcher(value);
			if (!matcher.find()) {
				return false;
			}
		}
		return true;
	}


	private static boolean validatorLengthMin(String value, int minLength) {
		if (value != null) {
			if (value.length() < minLength) {
				return false;
			}
		}
		return true;
	}

	private static boolean validatorLengthMax(String value, int maxLength) {
		if (value != null) {
			if (value.length() > maxLength) {
				return false;
			}
		}
		return true;
	}

	private static boolean validatorLongMin(Long value, long minValue) {
		if (value != null) {
			if (value < minValue) {
				return false;
			}
		}
		return true;
	}

	private static boolean validatorLongMax(Long value, long maxValue) {
		if (value != null) {
			if (value > maxValue) {
				return false;
			}
		}
		return true;
	}
	
}
