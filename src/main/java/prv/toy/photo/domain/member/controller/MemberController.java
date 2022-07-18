package prv.toy.photo.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import prv.toy.photo.common.jwt.JwtUtil;
import prv.toy.photo.domain.base.model.vo.BaseObject;
import prv.toy.photo.domain.member.model.service.MemberService;
import prv.toy.photo.domain.member.model.vo.Member;

@RestController
public class MemberController {

	@Autowired private MemberService<Member> memberService;
	@Autowired private JwtUtil jwtUtil;
	
	@GetMapping("/member/get")
	public Object findByOid() {
		Map<String, Object> test = new HashMap<>();
		test.put("qqq", 11);
		test.put("wwwwwwwww", 222222222);

		System.out.println(memberService.findById(123));

		return test;
	}

	@GetMapping("/test")
	public Object test() {

		// jwtUtil.create();
		// Member.build();
		Member a = new Member();
		// System.out.println(util.isNotNull(a));
		Map<String, Object> test = new HashMap<>();
		test.put("oid", 123);
		test.put("account", "test123");
		a.build(test);
		System.out.println(a.toString());
		System.out.println(a.getOid());

		return "";
	}
}
