package com.ghostsf.atool.util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import com.ghostsf.atool.exceptions.UtilException;
import com.ghostsf.atool.lang.Assert;

/**
 * 数字工具类<br>
 * 对于精确值计算应该使用 {@link BigDecimal}<br>
 * JDK7中<strong>BigDecimal(double val)</strong>构造方法的结果有一定的不可预知性，例如：
 * 
 * <pre>
 * new BigDecimal(0.1)
 * </pre>
 * 
 * 表示的不是<strong>0.1</strong>而是<strong>0.1000000000000000055511151231257827021181583404541015625</strong>
 * 
 * <p>
 * 这是因为0.1无法准确的表示为double。因此应该使用<strong>new BigDecimal(String)</strong>。
 * </p>
 * 相关介绍：
 * <ul>
 * <li>http://www.oschina.net/code/snippet_563112_25237</li>
 * <li>https://github.com/venusdrogon/feilong-core/wiki/one-jdk7-bug-thinking</li>
 * </ul>
 * 
 * @author ghostsf
 *
 */
public class NumberUtil {

	/** 默认除法运算精度 */
	private static final int DEFAUT_DIV_SCALE = 10;

	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 和
	 */
	public static double add(double v1, double v2) {
		return add(Double.toString(v1), Double.toString(v2)).doubleValue();
	}

	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 和
	 * @since 3.1.1
	 */
	public static double add(Double v1, Double v2) {
		return add((Number) v1, (Number) v2).doubleValue();
	}

	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 和
	 * @since 3.1.0
	 */
	public static BigDecimal add(Number v1, Number v2) {
		return add(v1.toString(), v2.toString());
	}

	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 和
	 * @since 3.0.8
	 */
	public static BigDecimal add(String v1, String v2) {
		return add(new BigDecimal(v1), new BigDecimal(v2));
	}

	/**
	 * 提供精确的加法运算
	 * 
	 * @param v1 被加数
	 * @param v2 加数
	 * @return 和
	 * @since 3.0.9
	 */
	public static BigDecimal add(BigDecimal v1, BigDecimal v2) {
		Assert.notNull(v1);
		Assert.notNull(v2);
		return v1.add(v2);
	}

	/**
	 * 提供精确的减法运算
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 差
	 */
	public static double sub(double v1, double v2) {
		return sub(Double.toString(v1), Double.toString(v2)).doubleValue();
	}

	/**
	 * 提供精确的减法运算
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 差
	 */
	public static double sub(Double v1, Double v2) {
		return sub((Number) v1, (Number) v2).doubleValue();
	}

	/**
	 * 提供精确的减法运算
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 差
	 * @since 3.1.0
	 */
	public static BigDecimal sub(Number v1, Number v2) {
		return sub(v1.toString(), v2.toString());
	}

	/**
	 * 提供精确的减法运算
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 差
	 * @since 3.0.8
	 */
	public static BigDecimal sub(String v1, String v2) {
		return sub(new BigDecimal(v1), new BigDecimal(v2));
	}

	/**
	 * 提供精确的减法运算
	 * 
	 * @param v1 被减数
	 * @param v2 减数
	 * @return 差
	 * @since 3.0.9
	 */
	public static BigDecimal sub(BigDecimal v1, BigDecimal v2) {
		Assert.notNull(v1);
		Assert.notNull(v2);
		return v1.subtract(v2);
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 积
	 */
	public static double mul(double v1, double v2) {
		return mul(Double.toString(v1), Double.toString(v2)).doubleValue();
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 积
	 */
	public static double mul(Double v1, Double v2) {
		return mul((Number) v1, (Number) v2).doubleValue();
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 积
	 */
	public static BigDecimal mul(Number v1, Number v2) {
		return mul(v1.toString(), v2.toString());
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 积
	 * @since 3.0.8
	 */
	public static BigDecimal mul(String v1, String v2) {
		return mul(new BigDecimal(v1), new BigDecimal(v2));
	}

	/**
	 * 提供精确的乘法运算
	 * 
	 * @param v1 被乘数
	 * @param v2 乘数
	 * @return 积
	 * @since 3.0.9
	 */
	public static BigDecimal mul(BigDecimal v1, BigDecimal v2) {
		Assert.notNull(v1);
		Assert.notNull(v2);
		return v1.multiply(v2);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2) {
		return div(v1, v2, DEFAUT_DIV_SCALE);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static double div(Double v1, Double v2) {
		return div(v1, v2, DEFAUT_DIV_SCALE);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 * @since 3.1.0
	 */
	public static BigDecimal div(Number v1, Number v2) {
		return div(v1, v2, DEFAUT_DIV_SCALE);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况的时候,精确到小数点后10位,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @return 两个参数的商
	 */
	public static BigDecimal div(String v1, String v2) {
		return div(v1, v2, DEFAUT_DIV_SCALE);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		return div(v1, v2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @return 两个参数的商
	 */
	public static double div(Double v1, Double v2, int scale) {
		return div(v1, v2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @return 两个参数的商
	 * @since 3.1.0
	 */
	public static BigDecimal div(Number v1, Number v2, int scale) {
		return div(v1, v2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度,后面的四舍五入
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @return 两个参数的商
	 */
	public static BigDecimal div(String v1, String v2, int scale) {
		return div(v1, v2, scale, RoundingMode.HALF_UP);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale, RoundingMode roundingMode) {
		return div(Double.toString(v1), Double.toString(v2), scale, roundingMode).doubleValue();
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 */
	public static double div(Double v1, Double v2, int scale, RoundingMode roundingMode) {
		return div((Number) v1, (Number) v2, scale, roundingMode).doubleValue();
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 * @since 3.1.0
	 */
	public static BigDecimal div(Number v1, Number v2, int scale, RoundingMode roundingMode) {
		return div(v1.toString(), v2.toString(), scale, roundingMode);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 */
	public static BigDecimal div(String v1, String v2, int scale, RoundingMode roundingMode) {
		return div(new BigDecimal(v1), new BigDecimal(v2), scale, roundingMode);
	}

	/**
	 * 提供(相对)精确的除法运算,当发生除不尽的情况时,由scale指定精确度
	 * 
	 * @param v1 被除数
	 * @param v2 除数
	 * @param scale 精确度，如果为负值，取绝对值
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 两个参数的商
	 * @since 3.0.9
	 */
	public static BigDecimal div(BigDecimal v1, BigDecimal v2, int scale, RoundingMode roundingMode) {
		Assert.notNull(v1);
		Assert.notNull(v2);
		if (scale < 0) {
			scale = -scale;
		}
		return v1.divide(v2, scale, roundingMode);
	}

	// ------------------------------------------------------------------------------------------- round
	/**
	 * 保留固定位数小数<br>
	 * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
	 * 例如保留2位小数：123.456789 =》 123.46
	 * 
	 * @param v 值
	 * @param scale 保留小数位数
	 * @return 新值
	 */
	public static BigDecimal round(double v, int scale) {
		return round(v, scale, RoundingMode.HALF_UP);
	}
	
	/**
	 * 保留固定位数小数<br>
	 * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
	 * 例如保留2位小数：123.456789 =》 123.46
	 * 
	 * @param v 值
	 * @param scale 保留小数位数
	 * @return 新值
	 */
	public static String roundStr(double v, int scale) {
		return round(v, scale).toString();
	}

	/**
	 * 保留固定位数小数<br>
	 * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
	 * 例如保留2位小数：123.456789 =》 123.46
	 * 
	 * @param numberStr 数字值的字符串表现形式
	 * @param scale 保留小数位数
	 * @return 新值
	 */
	public static BigDecimal round(String numberStr, int scale) {
		return round(numberStr, scale, RoundingMode.HALF_UP);
	}
	
	/**
	 * 保留固定位数小数<br>
	 * 采用四舍五入策略 {@link RoundingMode#HALF_UP}<br>
	 * 例如保留2位小数：123.456789 =》 123.46
	 * 
	 * @param numberStr 数字值的字符串表现形式
	 * @param scale 保留小数位数
	 * @return 新值
	 * @since 3.2.2
	 */
	public static String roundStr(String numberStr, int scale) {
		return round(numberStr, scale).toString();
	}

	/**
	 * 保留固定位数小数<br>
	 * 例如保留四位小数：123.456789 =》 123.4567
	 * 
	 * @param v 值
	 * @param scale 保留小数位数
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 新值
	 */
	public static BigDecimal round(double v, int scale, RoundingMode roundingMode) {
		return round(Double.toString(v), scale, roundingMode);
	}
	
	/**
	 * 保留固定位数小数<br>
	 * 例如保留四位小数：123.456789 =》 123.4567
	 * 
	 * @param v 值
	 * @param scale 保留小数位数
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 新值
	 * @since 3.2.2
	 */
	public static String roundStr(double v, int scale, RoundingMode roundingMode) {
		return round(v, scale, roundingMode).toString();
	}

	/**
	 * 保留固定位数小数<br>
	 * 例如保留四位小数：123.456789 =》 123.4567
	 * 
	 * @param numberStr 数字值的字符串表现形式
	 * @param scale 保留小数位数，如果传入小于0，则默认0
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}，如果传入null则默认四舍五入
	 * @return 新值
	 */
	public static BigDecimal round(String numberStr, int scale, RoundingMode roundingMode) {
		Assert.notBlank(numberStr);
		if(scale < 0) {
			scale = 0;
		}
		if(null == roundingMode) {
			roundingMode = RoundingMode.HALF_UP;
		}
		
		final BigDecimal b = new BigDecimal(numberStr);
		return b.setScale(scale, roundingMode);
	}
	
	/**
	 * 保留固定位数小数<br>
	 * 例如保留四位小数：123.456789 =》 123.4567
	 * 
	 * @param numberStr 数字值的字符串表现形式
	 * @param scale 保留小数位数
	 * @param roundingMode 保留小数的模式 {@link RoundingMode}
	 * @return 新值
	 * @since 3.2.2
	 */
	public static String roundStr(String numberStr, int scale, RoundingMode roundingMode) {
		return round(numberStr, scale, roundingMode).toString();
	}

	// ------------------------------------------------------------------------------------------- decimalFormat
	/**
	 * 格式化double<br>
	 * 对 {@link DecimalFormat} 做封装<br>
	 * 
	 * @param pattern 格式 格式中主要以 # 和 0 两种占位符号来指定数字长度。0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置。<br>
	 *            <ul>
	 *            <li>0 =》 取一位整数</li>
	 *            <li>0.00 =》 取一位整数和两位小数</li>
	 *            <li>00.000 =》 取两位整数和三位小数</li>
	 *            <li># =》 取所有整数部分</li>
	 *            <li>#.##% =》 以百分比方式计数，并取两位小数</li>
	 *            <li>#.#####E0 =》 显示为科学计数法，并取五位小数</li>
	 *            <li>,### =》 每三位以逗号进行分隔，例如：299,792,458</li>
	 *            <li>光速大小为每秒,###米 =》 将格式嵌入文本</li>
	 *            </ul>
	 * @param value 值
	 * @return 格式化后的值
	 */
	public static String decimalFormat(String pattern, double value) {
		return new DecimalFormat(pattern).format(value);
	}

	/**
	 * 格式化double<br>
	 * 对 {@link DecimalFormat} 做封装<br>
	 * 
	 * @param pattern 格式 格式中主要以 # 和 0 两种占位符号来指定数字长度。0 表示如果位数不足则以 0 填充，# 表示只要有可能就把数字拉上这个位置。<br>
	 *            <ul>
	 *            <li>0 =》 取一位整数</li>
	 *            <li>0.00 =》 取一位整数和两位小数</li>
	 *            <li>00.000 =》 取两位整数和三位小数</li>
	 *            <li># =》 取所有整数部分</li>
	 *            <li>#.##% =》 以百分比方式计数，并取两位小数</li>
	 *            <li>#.#####E0 =》 显示为科学计数法，并取五位小数</li>
	 *            <li>,### =》 每三位以逗号进行分隔，例如：299,792,458</li>
	 *            <li>光速大小为每秒,###米 =》 将格式嵌入文本</li>
	 *            </ul>
	 * @param value 值
	 * @return 格式化后的值
	 * @since 3.0.5
	 */
	public static String decimalFormat(String pattern, long value) {
		return new DecimalFormat(pattern).format(value);
	}

	/**
	 * 格式化金额输出，每三位用逗号分隔
	 * 
	 * @param value 金额
	 * @return 格式化后的值
	 * @since 3.0.9
	 */
	public static String decimalFormatMoney(double value) {
		return decimalFormat(",###", value);
	}
	
	/**
	 * 格式化百分比，小数采用四舍五入方式
	 * @param number 值
	 * @param scale 保留小数位数
	 * @return 百分比
	 * @since 3.2.3
	 */
	public static String formatPercent(double number, int scale) {
		final NumberFormat format = NumberFormat.getPercentInstance();
		format.setMaximumFractionDigits(scale);
		return format.format(number);
	}

	// ------------------------------------------------------------------------------------------- isXXX
	/**
	 * 是否为数字
	 * 
	 * @param str 字符串值
	 * @return 是否为数字
	 */
	public static boolean isNumber(String str) {
		if (StrUtil.isBlank(str)) {
			return false;
		}
		char[] chars = str.toCharArray();
		int sz = chars.length;
		boolean hasExp = false;
		boolean hasDecPoint = false;
		boolean allowSigns = false;
		boolean foundDigit = false;
		// deal with any possible sign up front
		int start = (chars[0] == '-') ? 1 : 0;
		if (sz > start + 1) {
			if (chars[start] == '0' && chars[start + 1] == 'x') {
				int i = start + 2;
				if (i == sz) {
					return false; // str == "0x"
				}
				// checking hex (it can't be anything else)
				for (; i < chars.length; i++) {
					if ((chars[i] < '0' || chars[i] > '9') && (chars[i] < 'a' || chars[i] > 'f') && (chars[i] < 'A' || chars[i] > 'F')) {
						return false;
					}
				}
				return true;
			}
		}
		sz--; // don't want to loop to the last char, check it afterwords
				// for type qualifiers
		int i = start;
		// loop to the next to last char or to the last char if we need another digit to
		// make a valid number (e.g. chars[0..5] = "1234E")
		while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				foundDigit = true;
				allowSigns = false;

			} else if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					// two decimal points or dec in exponent
					return false;
				}
				hasDecPoint = true;
			} else if (chars[i] == 'e' || chars[i] == 'E') {
				// we've already taken care of hex.
				if (hasExp) {
					// two E's
					return false;
				}
				if (!foundDigit) {
					return false;
				}
				hasExp = true;
				allowSigns = true;
			} else if (chars[i] == '+' || chars[i] == '-') {
				if (!allowSigns) {
					return false;
				}
				allowSigns = false;
				foundDigit = false; // we need a digit after the E
			} else {
				return false;
			}
			i++;
		}
		if (i < chars.length) {
			if (chars[i] >= '0' && chars[i] <= '9') {
				// no type qualifier, OK
				return true;
			}
			if (chars[i] == 'e' || chars[i] == 'E') {
				// can't have an E at the last byte
				return false;
			}
			if (chars[i] == '.') {
				if (hasDecPoint || hasExp) {
					// two decimal points or dec in exponent
					return false;
				}
				// single trailing decimal point after non-exponent is ok
				return foundDigit;
			}
			if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F')) {
				return foundDigit;
			}
			if (chars[i] == 'l' || chars[i] == 'L') {
				// not allowing L with an exponent
				return foundDigit && !hasExp;
			}
			// last character is illegal
			return false;
		}
		// allowSigns is true iff the val ends in 'E'
		// found digit it to make sure weird stuff like '.' and '1E-' doesn't pass
		return !allowSigns && foundDigit;
	}

	/**
	 * 判断String是否是整数
	 * 
	 * @param s String
	 * @return 是否为整数
	 */
	public static boolean isInteger(String s) {
		if (StrUtil.isNotBlank(s)) {
			return s.matches("^-?\\d+$");
		} else {
			return false;
		}
	}

	/**
	 * 判断字符串是否是浮点数
	 * 
	 * @param s String
	 * @return 是否为{@link Double}类型
	 */
	public static boolean isDouble(String s) {
		try {
			Double.parseDouble(s);
			if (s.contains(".")) {
				return true;
			}
			return false;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	/**
	 * 是否是质数<br>
	 * 质数表的质数又称素数。指整数在一个大于1的自然数中,除了1和此整数自身外,没法被其他自然数整除的数。
	 * 
	 * @param n 数字
	 * @return 是否是质数
	 */
	public static boolean isPrimes(int n) {
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}

	// ------------------------------------------------------------------------------------------- generateXXX

	/**
	 * 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
	 * 
	 * @param begin 最小数字（包含该数）
	 * @param end 最大数字（不包含该数）
	 * @param size 指定产生随机数的个数
	 * @return 随机int数组
	 */
	public static int[] generateRandomNumber(int begin, int end, int size) {
		if (begin > end) {
			int temp = begin;
			begin = end;
			end = temp;
		}
		// 加入逻辑判断，确保begin<end并且size不能大于该表示范围
		if ((end - begin) < size) {
			throw new UtilException("Size is larger than range between begin and end!");
		}
		// 种子你可以随意生成，但不能重复
		int[] seed = new int[end - begin];

		for (int i = begin; i < end; i++) {
			seed[i - begin] = i;
		}
		int[] ranArr = new int[size];
		Random ran = new Random();
		// 数量你可以自己定义。
		for (int i = 0; i < size; i++) {
			// 得到一个位置
			int j = ran.nextInt(seed.length - i);
			// 得到那个位置的数值
			ranArr[i] = seed[j];
			// 将最后一个未用的数字放到这里
			seed[j] = seed[seed.length - 1 - i];
		}
		return ranArr;
	}

	/**
	 * 生成不重复随机数 根据给定的最小数字和最大数字，以及随机数的个数，产生指定的不重复的数组
	 * 
	 * @param begin 最小数字（包含该数）
	 * @param end 最大数字（不包含该数）
	 * @param size 指定产生随机数的个数
	 * @return 随机int数组
	 */
	public static Integer[] generateBySet(int begin, int end, int size) {
		if (begin > end) {
			int temp = begin;
			begin = end;
			end = temp;
		}
		// 加入逻辑判断，确保begin<end并且size不能大于该表示范围
		if ((end - begin) < size) {
			throw new UtilException("Size is larger than range between begin and end!");
		}

		Random ran = new Random();
		Set<Integer> set = new HashSet<Integer>();
		while (set.size() < size) {
			set.add(begin + ran.nextInt(end - begin));
		}

		Integer[] ranArr = set.toArray(new Integer[size]);
		return ranArr;
	}

	// ------------------------------------------------------------------------------------------- range
	/**
	 * 从0开始给定范围内的整数列表，步进为1
	 * 
	 * @param stop 结束（包含）
	 * @return 整数列表
	 * @since 3.3.1
	 */
	public static int[] range(int stop) {
		return range(0, stop);
	}
	
	/**
	 * 给定范围内的整数列表，步进为1
	 * 
	 * @param start 开始（包含）
	 * @param stop 结束（包含）
	 * @return 整数列表
	 */
	public static int[] range(int start, int stop) {
		return range(start, stop, 1);
	}

	/**
	 * 给定范围内的整数列表
	 * 
	 * @param start 开始（包含）
	 * @param stop 结束（包含）
	 * @param step 步进
	 * @return 整数列表
	 */
	public static int[] range(int start, int stop, int step) {
		if (start < stop) {
			step = Math.abs(step);
		} else if (start > stop) {
			step = -Math.abs(step);
		} else {// start == end
			return new int[] { start };
		}

		int size = Math.abs((stop - start) / step) + 1;
		int[] values = new int[size];
		int index = 0;
		for (int i = start; (step > 0) ? i <= stop : i >= stop; i += step) {
			values[index] = i;
			index++;
		}
		return values;
	}

	/**
	 * 将给定范围内的整数添加到已有集合中，步进为1
	 * 
	 * @param start 开始（包含）
	 * @param stop 结束（包含）
	 * @param values 集合
	 * @return 集合
	 */
	public static Collection<Integer> appendRange(int start, int stop, Collection<Integer> values) {
		return appendRange(start, stop, 1, values);
	}

	/**
	 * 将给定范围内的整数添加到已有集合中
	 * 
	 * @param start 开始（包含）
	 * @param stop 结束（包含）
	 * @param step 步进
	 * @param values 集合
	 * @return 集合
	 */
	public static Collection<Integer> appendRange(int start, int stop, int step, Collection<Integer> values) {
		if (start < stop) {
			step = Math.abs(step);
		} else if (start > stop) {
			step = -Math.abs(step);
		} else {// start == end
			values.add(start);
			return values;
		}

		for (int i = start; (step > 0) ? i <= stop : i >= stop; i += step) {
			values.add(i);
		}
		return values;
	}

	// ------------------------------------------------------------------------------------------- others
	/**
	 * 阶乘：n!
	 * 
	 * @param n 值
	 * @return 阶乘
	 */
	public static int factorial(int n) {
		if (n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}

	/**
	 * 平方根算法<br>
	 * 推荐使用 {@link Math#sqrt(double)}
	 * 
	 * @param x 值
	 * @return 平方根
	 */
	public static long sqrt(long x) {
		long y = 0;
		long b = (~Long.MAX_VALUE) >>> 1;
		while (b > 0) {
			if (x >= y + b) {
				x -= y + b;
				y >>= 1;
				y += b;
			} else {
				y >>= 1;
			}
			b >>= 2;
		}
		return y;
	}

	/**
	 * 可以用于计算双色球、大乐透注数的方法<br>
	 * 比如大乐透35选5可以这样调用processMultiple(7,5); 就是数学中的：C75=7*6/2*1
	 * 
	 * @param selectNum 选中小球个数
	 * @param minNum 最少要选中多少个小球
	 * @return 注数
	 */
	public static int processMultiple(int selectNum, int minNum) {
		int result;
		result = mathSubnode(selectNum, minNum) / mathNode(selectNum - minNum);
		return result;
	}

	/**
	 * 最大公约数
	 * 
	 * @param m 第一个值
	 * @param n 第二个值
	 * @return 最大公约数
	 */
	public static int divisor(int m, int n) {
		while (m % n != 0) {
			int temp = m % n;
			m = n;
			n = temp;
		}
		return n;
	}

	/**
	 * 最小公倍数
	 * 
	 * @param m 第一个值
	 * @param n 第二个值
	 * @return 最小公倍数
	 */
	public static int multiple(int m, int n) {
		return m * n / divisor(m, n);
	}

	/**
	 * 获得数字对应的二进制字符串
	 * 
	 * @param number 数字
	 * @return 二进制字符串
	 */
	public static String getBinaryStr(Number number) {
		if (number instanceof Long) {
			return Long.toBinaryString((Long) number);
		} else if (number instanceof Integer) {
			return Integer.toBinaryString((Integer) number);
		} else {
			return Long.toBinaryString(number.longValue());
		}
	}

	/**
	 * 二进制转int
	 * 
	 * @param binaryStr 二进制字符串
	 * @return int
	 */
	public static int binaryToInt(String binaryStr) {
		return Integer.parseInt(binaryStr, 2);
	}

	/**
	 * 二进制转long
	 * 
	 * @param binaryStr 二进制字符串
	 * @return long
	 */
	public static long binaryToLong(String binaryStr) {
		return Long.parseLong(binaryStr, 2);
	}

	// ------------------------------------------------------------------------------------------- compare

	/**
	 * 比较两个值的大小
	 * 
	 * @see Character#compare(char, char)
	 * 
	 * @param x 第一个值
	 * @param y 第二个值
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 * @since 3.0.1
	 */
	public static int compare(char x, char y) {
		return x - y;
	}

	/**
	 * 比较两个值的大小
	 * 
	 * @see Double#compare(double, double)
	 * 
	 * @param x 第一个值
	 * @param y 第二个值
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 * @since 3.0.1
	 */
	public static int compare(double x, double y) {
		return Double.compare(x, y);
	}

	/**
	 * 比较两个值的大小
	 * 
	 * @see Integer#compare(int, int)
	 * 
	 * @param x 第一个值
	 * @param y 第二个值
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 * @since 3.0.1
	 */
	public static int compare(int x, int y) {
		if (x == y) {
			return 0;
		}
		if (x < y) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 比较两个值的大小
	 * 
	 * @see Long#compare(long, long)
	 * 
	 * @param x 第一个值
	 * @param y 第二个值
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 * @since 3.0.1
	 */
	public static int compare(long x, long y) {
		if (x == y) {
			return 0;
		}
		if (x < y) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 比较两个值的大小
	 * 
	 * @see Short#compare(short, short)
	 * 
	 * @param x 第一个值
	 * @param y 第二个值
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 * @since 3.0.1
	 */
	public static int compare(short x, short y) {
		if (x == y) {
			return 0;
		}
		if (x < y) {
			return -1;
		} else {
			return 1;
		}
	}

	/**
	 * 比较两个值的大小
	 * 
	 * @see Byte#compare(byte, byte)
	 * 
	 * @param x 第一个值
	 * @param y 第二个值
	 * @return x==y返回0，x&lt;y返回-1，x&gt;y返回1
	 * @since 3.0.1
	 */
	public static int compare(byte x, byte y) {
		return x - y;
	}

	/**
	 * 比较大小，参数1 &gt; 参数2 返回true
	 * 
	 * @param bigNum1 数字1
	 * @param bigNum2 数字2
	 * @return 是否大于
	 * @since 3,0.9
	 */
	public static boolean isGreater(BigDecimal bigNum1, BigDecimal bigNum2) {
		Assert.notNull(bigNum1);
		Assert.notNull(bigNum2);
		return bigNum1.compareTo(bigNum2) > 0;
	}

	/**
	 * 比较大小，参数1 &gt;= 参数2 返回true
	 *
	 * @param bigNum1 数字1
	 * @param bigNum2 数字2
	 * @return 是否大于等于
	 * @since 3,0.9
	 */
	public static boolean isGreaterOrEqual(BigDecimal bigNum1, BigDecimal bigNum2) {
		Assert.notNull(bigNum1);
		Assert.notNull(bigNum2);
		return bigNum1.compareTo(bigNum2) >= 0;
	}

	/**
	 * 比较大小，参数1 &lt; 参数2 返回true
	 *
	 * @param bigNum1 数字1
	 * @param bigNum2 数字2
	 * @return 是否小于
	 * @since 3,0.9
	 */
	public static boolean isLess(BigDecimal bigNum1, BigDecimal bigNum2) {
		Assert.notNull(bigNum1);
		Assert.notNull(bigNum2);
		return bigNum1.compareTo(bigNum2) < 0;
	}

	/**
	 * 比较大小，参数1&lt;=参数2 返回true
	 *
	 * @param bigNum1 数字1
	 * @param bigNum2 数字2
	 * @return 是否小于等于
	 * @since 3,0.9
	 */
	public static boolean isLessOrEqual(BigDecimal bigNum1, BigDecimal bigNum2) {
		Assert.notNull(bigNum1);
		Assert.notNull(bigNum2);
		return bigNum1.compareTo(bigNum2) <= 0;
	}

	/**
	 * 比较大小，值相等 返回true<br>
	 * 此方法通过调用{@link BigDecimal#compareTo(BigDecimal)}方法来判断是否相等<br>
	 * 此方法判断值相等时忽略精度的，既0.00 == 0
	 * 
	 * @param bigNum1 数字1
	 * @param bigNum2 数字2
	 * @return 是否相等
	 */
	public static boolean equals(BigDecimal bigNum1, BigDecimal bigNum2) {
		Assert.notNull(bigNum1);
		Assert.notNull(bigNum2);
		return 0 == bigNum1.compareTo(bigNum2);
	}

	/**
	 * 比较两个字符是否相同
	 * 
	 * @param c1 字符1
	 * @param c2 字符2
	 * @param ignoreCase 是否忽略大小写
	 * @return 是否相同
	 * @since 3.2.1
	 */
	public static boolean equals(char c1, char c2, boolean ignoreCase) {
		if (ignoreCase) {
			return Character.toLowerCase(c1) == Character.toLowerCase(c2);
		}
		return c1 == c2;
	}

	/**
	 * 数字转字符串<br>
	 * 调用{@link Number#toString()}，并去除尾小数点儿后多余的0
	 *
	 * @param number A Number
	 * @param defaultValue 如果number参数为{@code null}，返回此默认值
	 * @return A String.
	 * @since 3.0.9
	 */
	public static String toStr(Number number, String defaultValue) {
		return (null == number) ? defaultValue : toStr(number);
	}

	/**
	 * 数字转字符串<br>
	 * 调用{@link Number#toString()}，并去除尾小数点儿后多余的0
	 *
	 * @param number A Number
	 * @return A String.
	 */
	public static String toStr(Number number) {
		if (null == number) {
			throw new NullPointerException("Number is null !");
		}

		if (false == ObjectUtil.isValidIfNumber(number)) {
			throw new IllegalArgumentException("Number is non-finite!");
		}

		// 去掉小数点儿后多余的0
		String string = number.toString();
		if (string.indexOf('.') > 0 && string.indexOf('e') < 0 && string.indexOf('E') < 0) {
			while (string.endsWith("0")) {
				string = string.substring(0, string.length() - 1);
			}
			if (string.endsWith(".")) {
				string = string.substring(0, string.length() - 1);
			}
		}
		return string;
	}

	/**
	 * 是否空白符<br>
	 * 空白符包括空格、制表符、全角空格和不间断空格<br>
	 * 
	 * @see Character#isWhitespace(int)
	 * @see Character#isSpaceChar(int)
	 * @param c 字符
	 * @return 是否空白符
	 * @since 3.0.6
	 */
	public static boolean isBlankChar(char c) {
		return isBlankChar((int) c);
	}

	/**
	 * 是否空白符<br>
	 * 空白符包括空格、制表符、全角空格和不间断空格<br>
	 * 
	 * @see Character#isWhitespace(int)
	 * @see Character#isSpaceChar(int)
	 * @param c 字符
	 * @return 是否空白符
	 * @since 3.0.6
	 */
	public static boolean isBlankChar(int c) {
		return Character.isWhitespace(c) || Character.isSpaceChar(c);
	}

	/**
	 * 计算等份个数
	 * 
	 * @param total 总数
	 * @param part 每份的个数
	 * @return 分成了几份
	 * @since 3.0.6
	 */
	public static int count(int total, int part) {
		return (total % part == 0) ? (total / part) : (total / part + 1);
	}

	/**
	 * 空转0
	 * 
	 * @param decimal {@link BigDecimal}，可以为{@code null}
	 * @return {@link BigDecimal}参数为空时返回0的值
	 * @since 3.0.9
	 */
	public static BigDecimal null2Zero(BigDecimal decimal) {

		return decimal == null ? BigDecimal.ZERO : decimal;
	}

	/**
	 * 如果给定值为0，返回1，否则返回原值
	 * 
	 * @param value 值
	 * @return 1或非0值
	 * @since 3.1.2
	 */
	public static int zero2One(int value) {
		return 0 == value ? 1 : value;
	}

	/**
	 * 创建{@link BigInteger}，支持16进制、10进制和8进制，如果传入空白串返回null<br>
	 * from Apache Common Lang
	 * 
	 * @param str 数字字符串
	 * @return {@link BigInteger}
	 * @since 3.2.1
	 */
	public static BigInteger newBigInteger(String str) {
		str = StrUtil.trimToNull(str);
		if (null == str) {
			return null;
		}
		
		int pos = 0; //数字字符串位置
		int radix = 10;
		boolean negate = false; //负数与否
		if (str.startsWith("-")) {
			negate = true;
			pos = 1;
		}
		if (str.startsWith("0x", pos) || str.startsWith("0X", pos)) {
			// hex
			radix = 16;
			pos += 2;
		} else if (str.startsWith("#", pos)) {
			// alternative hex (allowed by Long/Integer)
			radix = 16;
			pos++;
		} else if (str.startsWith("0", pos) && str.length() > pos + 1) {
			// octal; so long as there are additional digits
			radix = 8;
			pos++;
		} // default is to treat as decimal

		if(pos > 0) {
			str = str.substring(pos);
		}
		final BigInteger value = new BigInteger(str, radix);
		return negate ? value.negate() : value;
	}

	// ------------------------------------------------------------------------------------------- Private method start
	private static int mathSubnode(int selectNum, int minNum) {
		if (selectNum == minNum) {
			return 1;
		} else {
			return selectNum * mathSubnode(selectNum - 1, minNum);
		}
	}

	private static int mathNode(int selectNum) {
		if (selectNum == 0) {
			return 1;
		} else {
			return selectNum * mathNode(selectNum - 1);
		}
	}
	// ------------------------------------------------------------------------------------------- Private method end
}
