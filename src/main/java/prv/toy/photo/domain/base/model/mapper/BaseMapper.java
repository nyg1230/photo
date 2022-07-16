package prv.toy.photo.domain.base.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "baseMapper")
public interface BaseMapper<VO> {

	@SelectProvider(type = BaseSql.class, method = "selectById")
	VO selectById(@Param("tableName") String tableName, @Param("oid") long oid, String selectComumn);
}
