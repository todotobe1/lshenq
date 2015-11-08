package cn.lshenq.booking.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.lshenq.base.domain.AbstractEntity;
import cn.lshenq.base.repository.BaseRepository;
import cn.lshenq.base.service.impl.BaseServiceImpl;
import cn.lshenq.booking.repository.BookingRepository;
import cn.lshenq.booking.service.BookingService;

@Service("orderService")
public class BookingServiceImpl extends BaseServiceImpl implements BookingService {

	@Autowired
	BookingRepository bookingRepository;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public BaseRepository<AbstractEntity, Long> getRepository() {
		return (BaseRepository) bookingRepository;
	}

	@Override
	public AbstractEntity findEntityByNo(String no) {
		return bookingRepository.findEntityByBookingNo(no);
	}
}
