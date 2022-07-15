package prv.toy.photo.domain.base.model.service;

public interface BaseService<VO> {
	VO findById(long oid);
}
