package prv.toy.photo.domain.base.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

@Mapper
@Component(value = "baseMapper")
public interface BaseMapper<VO> {
	VO findById(@Param("oid") long oid);
}
