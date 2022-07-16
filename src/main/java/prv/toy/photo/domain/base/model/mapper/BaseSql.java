package prv.toy.photo.domain.base.model.mapper;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

public class BaseSql {

	public String selectById(
		@Param("tableName") String tableName,
		@Param("oid") long oid,
		String selectComumn)
	{
		SQL sql = new SQL() {{
			SELECT(selectComumn);
			FROM("${tableName}");
			WHERE("oid = #{oid}");
		}};
		return sql.toString();
	}
	
}
