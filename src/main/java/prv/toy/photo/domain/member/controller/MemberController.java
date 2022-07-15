package prv.toy.photo.domain.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import prv.toy.photo.domain.member.model.service.MemberService;
import prv.toy.photo.domain.member.model.vo.Member;

@RestController
public class MemberController {

	@Autowired
	private MemberService<Member> memberService;
	
	@GetMapping("/member/get")
	public Object findByOid() {
		Map<String, Object> test = new HashMap<>();
		test.put("qqq", 11);
		test.put("wwwwwwwww", 222222222);

		System.out.println(memberService.findById(123));

		return test;
	}
}
