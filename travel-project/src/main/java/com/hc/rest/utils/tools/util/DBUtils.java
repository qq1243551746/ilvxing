package com.hc.rest.utils.tools.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>
 * Title:
 * </p>
 * 数据库连接辅助类
 * <p>
 * Description:
 * </p>
 * 数据库连接辅助类
 * <p>
 * Copyright: Copyright (c) 2012
 * </p>
 * 
 * <p>
 * Company:Tidestone
 * </p>
 * 
 * @author not attributable
 * @version 1.0
 */
public class DBUtils {
	private static Logger log = LoggerFactory.getLogger(DBUtils.class);

	public static List<Map<String, Object>> querySql(Connection mysql_conn, String sql) {
		List<Map<String, Object>> list = new ArrayList<>();
		Statement psmt = null;
		ResultSet rs = null;
		try {
			psmt = mysql_conn.createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
			rs = psmt.executeQuery(sql);
			ResultSetMetaData rsmt = rs.getMetaData();
			if (!rs.isLast()) {
				while (rs.next()) {
					Map<String, Object> ht = new HashMap<String, Object>();
					for (int i = 1; i <= rsmt.getColumnCount(); i++) {
						ht.put(rsmt.getColumnName(i).toLowerCase(), "" + rs.getString(i));
					}
					list.add(ht);
				}
			}
			return list;
		} catch (Exception e) {
			log.error("querySql Exception:" + sql, e);
			return new ArrayList<>();
		} finally {
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
				if (psmt != null) {
					psmt.close();
					psmt = null;
				}
			} catch (SQLException ex) {
				log.error("Closed Exception:", ex);
			}
		}
	}
}
