package prv.toy.photo.domain.member.model.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import prv.toy.photo.domain.base.model.mapper.BaseMapper;

@Mapper
@Component(value = "memberMapper")
public interface MemberMapper<Member> extends BaseMapper<Member> {
	String tableName = "member";
}
