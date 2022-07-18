package prv.toy.photo.domain.member.model.vo;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import prv.toy.photo.domain.base.model.vo.BaseObject;

@Data
@EqualsAndHashCode(callSuper=true)
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseObject {
	public static final String TABLE_NAME = "member";

	private String account;
	private String pw;
	private String email;
	private Date modifiedAt;
	private boolean isDelete;
	private Date delte;
}
