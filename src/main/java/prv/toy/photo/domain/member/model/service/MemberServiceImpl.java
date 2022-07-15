package prv.toy.photo.domain.member.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import prv.toy.photo.domain.base.model.service.BaseServiceImpl;
import prv.toy.photo.domain.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl<Member> extends BaseServiceImpl implements MemberService {
	
	// @Autowired
	private MemberMapper<Member> memberMapper;

}
