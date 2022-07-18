package prv.toy.photo.domain.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import prv.toy.photo.domain.base.model.service.BaseServiceImpl;
import prv.toy.photo.domain.member.model.mapper.MemberMapper;
import prv.toy.photo.domain.member.model.vo.Member;

@Service
@Component(value = "Service")
public class MemberServiceImpl<VO> extends BaseServiceImpl<VO> implements MemberService<VO> {

	@Override
	public String getTableName() {
		return Member.TABLE_NAME;
	}

	@Override public List<String> getColumns() {
		List<String> test = new ArrayList<>();
		return test;
	}

	@Autowired
	private MemberMapper<Member> memberMapper;

}
