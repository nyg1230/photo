package prv.toy.photo.domain.member.model.vo;

import java.sql.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import prv.toy.photo.domain.base.model.vo.BaseObject;

@Data
@EqualsAndHashCode(callSuper=true)
public class Member extends BaseObject {
	private String account;
	private String pw;
	private String email;
	private Date createdAt;
	private Date modifiedAt;
	private boolean isDelete;
	private Date delte;
}
