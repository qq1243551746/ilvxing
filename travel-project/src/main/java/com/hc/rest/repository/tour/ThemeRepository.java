package com.hc.rest.repository.tour;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hc.rest.entity.tour.Theme;

/**
 * 主题
 * 
 * @author MaiBenBen
 *
 */
public interface ThemeRepository extends JpaRepository<Theme, Integer> {

	/**
	 * 主题表与主题表连接,查询所有
	 * 
	 * @param parent
	 *            父级区域
	 * @return
	 */
	@Query(value = "select t from Theme t where t.parent=:id")
	List<Theme> parentList(@Param("id") Integer id);
}
