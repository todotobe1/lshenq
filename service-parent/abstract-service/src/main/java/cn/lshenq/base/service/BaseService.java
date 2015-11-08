package cn.lshenq.base.service;

import java.util.List;
import java.util.Set;

import cn.lshenq.base.domain.AbstractEntity;

public interface BaseService {
	public AbstractEntity saveEntity(AbstractEntity entity);
	public List<AbstractEntity> findAllEntity();
	List<AbstractEntity> findAllEntity(Set<Long> ids);
	public AbstractEntity findEntityById(Long id);
	public AbstractEntity findEntityByNo(String no);
	public void deleteEntity(AbstractEntity entity);
	public void deleteEntity(Long id);
}
