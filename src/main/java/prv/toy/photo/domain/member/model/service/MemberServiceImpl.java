package prv.toy.photo.domain.member.model.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import prv.toy.photo.domain.base.model.service.BaseServiceImpl;
import prv.toy.photo.domain.member.model.mapper.MemberMapper;

@Service
@Component(value = "Service")
public class MemberServiceImpl<Member> extends BaseServiceImpl<Member> implements MemberService<Member> {

	@Override
	public String getTableName() {
		return "member";
	}

	@Override public List<String> getColumns() {
		List<String> test = new ArrayList<>();
		return test;
	}

	@Autowired
	private MemberMapper<Member> memberMapper;

}
