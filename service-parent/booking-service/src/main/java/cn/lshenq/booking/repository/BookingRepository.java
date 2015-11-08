
package cn.lshenq.booking.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import cn.lshenq.base.repository.BaseRepository;
import cn.lshenq.booking.entity.BookingEntity;

@Repository
public interface BookingRepository extends BaseRepository<BookingEntity, Long> {
	@Query("select b from BookingEntity b where b.bookingNo = ?1")
	public BookingEntity findEntityByBookingNo(String bookingNo);
}
