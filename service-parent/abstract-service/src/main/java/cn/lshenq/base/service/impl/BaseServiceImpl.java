package cn.lshenq.base.service.impl;

import java.util.List;
import java.util.Set;

import cn.lshenq.base.domain.AbstractEntity;
import cn.lshenq.base.repository.BaseRepository;
import cn.lshenq.base.service.BaseService;

public abstract class BaseServiceImpl implements BaseService {

	@Override
	public List<AbstractEntity> findAllEntity(Set<Long> ids) {
		return (List<AbstractEntity>)getRepository().findAll(ids);
	}

	@Override
	public AbstractEntity saveEntity(AbstractEntity entity) {
		return getRepository().save(entity);
	}

	@Override
	public AbstractEntity findEntityById(Long id) {
		return getRepository().findOne(id);
	}

	@Override
	public void deleteEntity(AbstractEntity entity) {
		getRepository().delete(entity);
	}

	@Override
	public void deleteEntity(Long id) {
		getRepository().delete(id);
	}
	

	@Override
	public List<AbstractEntity> findAllEntity() {
		return (List<AbstractEntity>) getRepository().findAll();
	}

	public abstract BaseRepository<AbstractEntity, Long> getRepository();
}
