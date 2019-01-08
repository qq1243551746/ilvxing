package com.hc.rest.utils.tools.util;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.alibaba.fastjson.serializer.ValueFilter;

/**
 * Json工具类
 * 
 * @author JustinYang
 * @version 1.0
 * @since 2016-07-22
 *
 */
public class JsonUtils {

	public static ValueFilter filter = new ValueFilter() {
		public Object process(Object obj, String s, Object v) {
			if (v == null) {
				return "";
			} else if (v instanceof java.lang.String) {
				v = v.toString().trim();
			}
			return v;
		}
	};

	/**
	 * 转化为标准JSON<br/>
	 * 1.日期格式转化为yyyy-MM-dd HH:mm:ss；<br/>
	 * 2.如果键值对类型，当值为null时，也会进行转换
	 * 
	 * @param object
	 *            需要转换的对象
	 * @return 转换后的JSON对象
	 */
	public static JSONObject toJSONObject(Object object) {
		SerializeConfig config = new SerializeConfig();
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		config.put(Timestamp.class, new SimpleDateFormatSerializer(dateFormat));
		String jsonString = JSONObject.toJSONString(object, config, filter);
		JSONObject result = JSONObject.parseObject(jsonString);
		return result;
	}

	/**
	 * 转化为标准JSON<br/>
	 * 1.日期格式转化为yyyy-MM-dd HH:mm:ss；<br/>
	 * 2.如果键值对类型，当值为null时，也会进行转换
	 * 
	 * @param object
	 *            需要转换的对象
	 * @return 转换后的JSON对象
	 */
	public static JSONArray toJSONArray(Object object) {
		SerializeConfig config = new SerializeConfig();
		String dateFormat = "yyyy-MM-dd HH:mm:ss";
		config.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
		config.put(Timestamp.class, new SimpleDateFormatSerializer(dateFormat));
		String jsonString = JSONArray.toJSONString(object, config, filter);
		JSONArray result = JSONArray.parseArray(jsonString);
		return result;
	}

	/**
	 * 格式化JSON字符串
	 * 
	 * @param json
	 *            JSON字符串
	 * @return 格式化后的JSON串
	 */
	public static String formatJSON(String json) {
		return formatJSON(json, "   ");
	}

	/**
	 * json字符串的格式化
	 * 
	 * @author JustinYang
	 * @param json
	 *            需要格式的json串
	 * @param fillStringUnit每一层之前的占位符号比如空格
	 *            制表符
	 * @return
	 */
	public static String formatJSON(String json, String fillStringUnit) {
		if (json == null || json.trim().length() == 0) {
			return null;
		}

		int fixedLenth = 0;
		ArrayList<String> tokenList = new ArrayList<String>();
		{
			String jsonTemp = json;
			// 预读取
			while (jsonTemp.length() > 0) {
				String token = getToken(jsonTemp);
				jsonTemp = jsonTemp.substring(token.length());
				token = token.trim();
				tokenList.add(token);
			}
		}

		for (int i = 0; i < tokenList.size(); i++) {
			String token = tokenList.get(i);
			int length = token.getBytes().length;
			if (length > fixedLenth && i < tokenList.size() - 1 && tokenList.get(i + 1).equals(":")) {
				fixedLenth = length;
			}
		}

		StringBuilder buf = new StringBuilder();
		int count = 0;
		for (int i = 0; i < tokenList.size(); i++) {

			String token = tokenList.get(i);

			if (token.equals(",")) {
				buf.append(token);
				doFill(buf, count, fillStringUnit);
				continue;
			}
			if (token.equals(":")) {
				buf.append(" ").append(token).append(" ");
				continue;
			}
			if (token.equals("{")) {
				String nextToken = tokenList.get(i + 1);
				if (nextToken.equals("}")) {
					i++;
					buf.append("{ }");
				} else {
					count++;
					buf.append(token);
					doFill(buf, count, fillStringUnit);
				}
				continue;
			}
			if (token.equals("}")) {
				count--;
				doFill(buf, count, fillStringUnit);
				buf.append(token);
				continue;
			}
			if (token.equals("[")) {
				String nextToken = tokenList.get(i + 1);
				if (nextToken.equals("]")) {
					i++;
					buf.append("[ ]");
				} else {
					count++;
					buf.append(token);
					doFill(buf, count, fillStringUnit);
				}
				continue;
			}
			if (token.equals("]")) {
				count--;
				doFill(buf, count, fillStringUnit);
				buf.append(token);
				continue;
			}

			buf.append(token);
			// 左对齐
			if (i < tokenList.size() - 1 && tokenList.get(i + 1).equals(":")) {
				int fillLength = fixedLenth - token.getBytes().length;
				if (fillLength > 0) {
					for (int j = 0; j < fillLength; j++) {
						buf.append(" ");
					}
				}
			}
		}
		return buf.toString();
	}

	private static String getToken(String json) {
		StringBuilder buf = new StringBuilder();
		boolean isInYinHao = false;
		while (json.length() > 0) {
			String token = json.substring(0, 1);
			json = json.substring(1);

			if (!isInYinHao && (token.equals(":") || token.equals("{") || token.equals("}") || token.equals("[") || token.equals("]") || token.equals(","))) {
				if (buf.toString().trim().length() == 0) {
					buf.append(token);
				}

				break;
			}

			if (token.equals("\\")) {
				buf.append(token);
				buf.append(json.substring(0, 1));
				json = json.substring(1);
				continue;
			}
			if (token.equals("\"")) {
				buf.append(token);
				if (isInYinHao) {
					break;
				} else {
					isInYinHao = true;
					continue;
				}
			}
			buf.append(token);
		}
		return buf.toString();
	}

	private static void doFill(StringBuilder buf, int count, String fillStringUnit) {
		buf.append("\n");
		for (int i = 0; i < count; i++) {
			buf.append(fillStringUnit);
		}
	}
}
