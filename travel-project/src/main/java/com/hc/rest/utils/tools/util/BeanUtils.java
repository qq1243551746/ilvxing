package com.hc.rest.utils.tools.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanUtils<T> implements Serializable {

	private static final long serialVersionUID = -4411690036448759156L;

	/**
	 * 批量List Map转Bean
	 * 
	 * @param oldList
	 * @param type
	 * @return
	 * @throws Exception
	 */
	public List<T> mapToBean(Class<T> type, List<Map<String, Object>> oldList) throws Exception {
		List<T> newList = new ArrayList<T>();
		for (Map<String, Object> oldMap : oldList) {
			Map<String, Object> newMap = mapKeyToJavaKey(oldMap);
			newList.add(mapToBean(type, newMap));
			oldMap.clear(); // 清除缓存
		}
		oldList.clear();// 清除缓存
		return newList;
	}

	/**
	 * 将一个 Map 对象转化为一个 JavaBean
	 * 
	 * @param type
	 *            要转化的类型
	 * @param map
	 *            包含属性值的 map
	 * @return 转化出来的 JavaBean 对象
	 * @throws IntrospectionException
	 *             如果分析类属性失败
	 * @throws IllegalAccessException
	 *             如果实例化 JavaBean 失败
	 * @throws InstantiationException
	 *             如果实例化 JavaBean 失败
	 * @throws InvocationTargetException
	 *             如果调用属性的 setter 方法失败
	 */
	public T mapToBean(Class<T> type, Map<String, Object> map) throws IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
		BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性
		T obj = type.newInstance(); // 创建 JavaBean 对象

		// 给 JavaBean 对象的属性赋值
		PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
		for (int i = 0; i < propertyDescriptors.length; i++) {
			PropertyDescriptor descriptor = propertyDescriptors[i];
			String propertyName = descriptor.getName();

			if (map.containsKey(propertyName)) {
				// 下面一句可以 try 起来，这样当一个属性赋值失败的时候就不会影响其他属性赋值。
				try {

					Object value = map.get(propertyName);
					if (value == null) {
						continue;
					}
					Object[] args = new Object[1];

					String typeName = descriptor.getPropertyType().getName();
					if (typeName.equals("java.math.BigDecimal")) {
						value = new BigDecimal(value.toString());
					} else if (typeName.equals("java.util.Date")) {
						SimpleDateFormat timeSdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						value = timeSdf.parse(value.toString());
					} else if (typeName.equals("java.lang.Integer")) {
						value = Integer.parseInt(value.toString());
					}
					args[0] = value;
					descriptor.getWriteMethod().invoke(obj, args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return obj;
	}

	public T covertToBean(Class<T> type, Map<String, String> map) throws Exception {
		Map<String, Object> newMap = mapConvert(map);
		return mapToBean(type, newMap);
	}

	/**
	 * 将Map的Key值转换为标准的实体Bean的属性命名规则
	 * 
	 * @param oldList
	 *            需要转换的集合
	 * @return 新的集合
	 */
	public List<Map<String, Object>> listMapKeyToJavaKey(List<Map<String, Object>> oldList) {
		List<Map<String, Object>> newList = new ArrayList<>();
		for (Map<String, Object> oldMap : oldList) {
			Map<String, Object> newMap = mapKeyToJavaKey(oldMap);
			newList.add(newMap);
			oldMap.clear(); // 清除缓存
		}
		oldList.clear();// 清除缓存
		return newList;
	}

	/**
	 * 将Map的Key值转换为标准的实体Bean的属性命名规则
	 * 
	 * @param oldMap
	 *            需要转换的Map
	 * @return 新的Map
	 */
	public Map<String, Object> mapKeyToJavaKey(Map<String, Object> oldMap) {
		Map<String, Object> newMap = new HashMap<>();
		for (String oldKey : oldMap.keySet()) { // 遍历Key值
			String newKey = makeAllWordFirstLetterUpperCase(oldKey);// 转换为新Key
			newMap.put(newKey, oldMap.get(oldKey));
		}
		return newMap;
	}

	public Map<String, Object> mapConvert(Map<String, String> oldMap) {
		Map<String, Object> newMap = new HashMap<>();
		for (String oldKey : oldMap.keySet()) { // 遍历Key值
			String newKey = makeAllWordFirstLetterUpperCase(oldKey);// 转换为新Key
			newMap.put(newKey, oldMap.get(oldKey));
		}
		return newMap;
	}

	/**
	 * 转换column为标准bean字段
	 * 
	 * @param sqlName
	 * @return
	 */
	private String makeAllWordFirstLetterUpperCase(String key) {
		String beanKey = toUnderscoreName(key);
		String[] strs = beanKey.toLowerCase().split("_");
		StringBuffer result = new StringBuffer();
		String preStr = "";
		for (int i = 0; i < strs.length; i++) {
			if (preStr.length() == 1) {
				result.append(strs[i]);
			} else {
				result.append(changeFirstCharacterCase(strs[i], true));
			}
			preStr = strs[i];
		}
		return changeFirstCharacterCase(result.toString(), false);
	}

	/**
	 * 将字符串首字母进行大写或小写转换
	 * 
	 * @param str
	 *            需要转换的字符串
	 * @param capitalize
	 *            true：大写；false：小写；
	 * @return 转换后的字符串
	 */
	private String changeFirstCharacterCase(String str, boolean capitalize) {
		if (str == null || str.length() == 0) {
			return str;
		}
		StringBuffer buf = new StringBuffer(str.length());
		if (capitalize) {
			buf.append(Character.toUpperCase(str.charAt(0)));
		} else {
			buf.append(Character.toLowerCase(str.charAt(0)));
		}
		buf.append(str.substring(1));
		return buf.toString();
	}

	/**
	 * Convert a name in camelCase to an underscored name in lower case. Any upper case letters are converted to lower case with a preceding underscore.
	 * 
	 * @param filteredName
	 *            the string containing original name
	 * @return the converted name
	 */
	private String toUnderscoreName(String name) {
		if (name == null)
			return null;

		String filteredName = name;
		if (filteredName.indexOf("_") >= 0 && filteredName.equals(filteredName.toUpperCase())) {
			filteredName = filteredName.toLowerCase();
		}
		if (filteredName.indexOf("_") == -1 && filteredName.equals(filteredName.toUpperCase())) {
			filteredName = filteredName.toLowerCase();
		}

		StringBuffer result = new StringBuffer();
		if (filteredName != null && filteredName.length() > 0) {
			result.append(filteredName.substring(0, 1).toLowerCase());
			for (int i = 1; i < filteredName.length(); i++) {
				String preChart = filteredName.substring(i - 1, i);
				String c = filteredName.substring(i, i + 1);
				if (c.equals("_")) {
					result.append("_");
					continue;
				}
				if (preChart.equals("_")) {
					result.append(c.toLowerCase());
					continue;
				}
				if (c.matches("\\d")) {
					result.append(c);
				} else if (c.equals(c.toUpperCase())) {
					result.append("_");
					result.append(c.toLowerCase());
				} else {
					result.append(c);
				}
			}
		}
		return result.toString();
	}
}
