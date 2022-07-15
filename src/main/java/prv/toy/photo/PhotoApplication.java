package prv.toy.photo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import prv.toy.photo.domain.base.model.mapper.BaseMapper;
import prv.toy.photo.domain.member.model.mapper.MemberMapper;

@SpringBootApplication
@ComponentScan(basePackageClasses = { MemberMapper.class, BaseMapper.class })
public class PhotoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoApplication.class, args);
	}

}
