package prv.toy.photo.domain.base.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import prv.toy.photo.common.Util;
import prv.toy.photo.domain.base.model.mapper.BaseMapper;

@Service
@Component(value = "baseService")
public class BaseServiceImpl<VO> implements BaseService<VO> {

	@Autowired private BaseMapper<VO> baseMapper;
	@Autowired private Util util;

	public String getTableName() {
		return null;
	}

	public List<String> getColumns() {
		return null;
	}

	private String selectComumn() {
		List<String> columns = this.getColumns();
		String selectComumn = null;

		if (util.isNotNull(columns)) {
			selectComumn = String.join(",", columns);
		}

		return selectComumn;
	}

	@Override
	public VO findById(long oid) {
		return baseMapper.selectById(this.getTableName(), oid, this.selectComumn());
	}
	
}
