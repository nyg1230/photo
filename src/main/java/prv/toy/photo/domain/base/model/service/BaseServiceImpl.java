package prv.toy.photo.domain.base.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import prv.toy.photo.domain.base.model.mapper.BaseMapper;

@Service
@Component(value = "baseService")
public class BaseServiceImpl<VO, ID> implements BaseService<VO> {

	@Autowired(required = false)
 	private BaseMapper<VO> baseMapper;

	@Override
	public VO findById(long oid) {
		return baseMapper.findById(oid);
	}
	
}
