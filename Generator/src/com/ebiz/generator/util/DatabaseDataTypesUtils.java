package com.ebiz.generator.util;

import java.sql.Types;
import java.util.HashMap;


public class DatabaseDataTypesUtils {

	private final static IntStringMap _preferredJavaTypeForSqlType = new IntStringMap();

	public static boolean isFloatNumber(int sqlType, int size, int decimalDigits) {
		String javaType = getPreferredJavaType(sqlType, size, decimalDigits);
		if (javaType.endsWith("Float") || javaType.endsWith("Double") || javaType.endsWith("BigDecimal")) {
			return true;
		}
		return false;
	}

	public static boolean isIntegerNumber(int sqlType, int size, int decimalDigits) {
		String javaType = getPreferredJavaType(sqlType, size, decimalDigits);
		if (javaType.endsWith("Long") || javaType.endsWith("Integer") || javaType.endsWith("Short")
				|| javaType.endsWith("Byte")) {
			return true;
		}
		return false;
	}

	public static boolean isDate(int sqlType, int size, int decimalDigits) {
		String javaType = getPreferredJavaType(sqlType, size, decimalDigits);
		if (javaType.endsWith("Date") || javaType.endsWith("Timestamp") || javaType.endsWith("Time")) {
			return true;
		}
		return false;
	}

	public static boolean isClob(int sqlType, int size, int decimalDigits) {
		if (sqlType == Types.CLOB) {
			return true;
		}
		return false;
	}

	public static String getPreferredJavaType(int sqlType, int size, int decimalDigits) {
		if ((sqlType == Types.DECIMAL || sqlType == Types.NUMERIC) && decimalDigits == 0) {
			if (size == 1) {
				// https://sourceforge.net/tracker/?func=detail&atid=415993&aid=662953&group_id=36044
				// return "java.lang.Boolean";
				return "java.lang.Integer";
			} else if (size < 3) {
				// return "java.lang.Byte";
				return "java.lang.Integer";
			} else if (size < 5) {
				// return "java.lang.Short";
				return "java.lang.Integer";
			} else if (size < 10) {
				return "java.lang.Integer";
			} else if (size < 19) {
				return "java.lang.Long";
			} else {
				return "java.lang.Long";
				//return "java.math.BigDecimal";
			}
		}
		String result = _preferredJavaTypeForSqlType.getString(sqlType);
		if (result == null) {
			result = "java.lang.Object";
		}
		return result;
	}

	static {
		_preferredJavaTypeForSqlType.put(Types.TINYINT, "java.lang.Byte");
		_preferredJavaTypeForSqlType.put(Types.SMALLINT, "java.lang.Short");
		_preferredJavaTypeForSqlType.put(Types.INTEGER, "java.lang.Integer");
		_preferredJavaTypeForSqlType.put(Types.BIGINT, "java.lang.Long");
		_preferredJavaTypeForSqlType.put(Types.REAL, "java.lang.Float");
		_preferredJavaTypeForSqlType.put(Types.FLOAT, "java.lang.Double");
		_preferredJavaTypeForSqlType.put(Types.DOUBLE, "java.lang.Double");
		_preferredJavaTypeForSqlType.put(Types.DECIMAL, "java.math.BigDecimal");
		_preferredJavaTypeForSqlType.put(Types.NUMERIC, "java.math.BigDecimal");
		_preferredJavaTypeForSqlType.put(Types.BIT, "java.lang.Boolean");
		_preferredJavaTypeForSqlType.put(Types.BOOLEAN, "java.lang.Boolean");
		_preferredJavaTypeForSqlType.put(Types.CHAR, "java.lang.String");
		_preferredJavaTypeForSqlType.put(Types.VARCHAR, "java.lang.String");
		// according to resultset.gif, we should use java.io.Reader, but String
		// is more convenient for EJB
		_preferredJavaTypeForSqlType.put(Types.LONGVARCHAR, "java.lang.String");
		_preferredJavaTypeForSqlType.put(Types.BINARY, "byte[]");
		_preferredJavaTypeForSqlType.put(Types.VARBINARY, "byte[]");
		_preferredJavaTypeForSqlType.put(Types.LONGVARBINARY, "byte[]");
		_preferredJavaTypeForSqlType.put(Types.DATE, "java.util.Date");
		_preferredJavaTypeForSqlType.put(Types.TIME, "java.util.Date");
		_preferredJavaTypeForSqlType.put(Types.TIMESTAMP, "java.util.Date");
		
//		_preferredJavaTypeForSqlType.put(Types.TIME, "java.sql.Time");
//		_preferredJavaTypeForSqlType.put(Types.TIMESTAMP, "java.sql.Timestamp");
		_preferredJavaTypeForSqlType.put(Types.CLOB, "java.lang.String");
		_preferredJavaTypeForSqlType.put(Types.BLOB, "java.sql.Blob");
		_preferredJavaTypeForSqlType.put(Types.ARRAY, "java.sql.Array");
		_preferredJavaTypeForSqlType.put(Types.REF, "java.sql.Ref");
		_preferredJavaTypeForSqlType.put(Types.STRUCT, "java.lang.Object");
		_preferredJavaTypeForSqlType.put(Types.JAVA_OBJECT, "java.lang.Object");
	}

	private static class IntStringMap extends HashMap<Object, Object> {

		/** 
		* @Fields serialVersionUID : TODO
		*/ 
		private static final long serialVersionUID = 1L;

		public String getString(int i) {
			return (String) get(new Integer(i));
		}

		@SuppressWarnings("unused")
		public String[] getStrings(int i) {
			return (String[]) get(new Integer(i));
		}

		public void put(int i, String s) {
			put(new Integer(i), s);
		}

		@SuppressWarnings("unused")
		public void put(int i, String[] sa) {
			put(new Integer(i), sa);
		}
	}

}
