package cn.lshenq.api.booking;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cn.lshenq.booking.entity.BookingEntity;
import cn.lshenq.booking.service.BookingService;

@RestController
@ExposesResourceFor(BookingEntity.class)
@RequestMapping(value = "/bookings")
public class BookingController {
	@Autowired
	BookingService bookingService;

	@RequestMapping("/")
	public String helloWorld() {
		return "lshenq-web is running.";
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{bookingNo}")
	@ResponseBody
	public ResponseEntity<BookingEntity> getBookingByNo(@PathVariable String bookingNo) {
		BookingEntity bookingEntity = (BookingEntity) bookingService.findEntityByNo(bookingNo);
		return new ResponseEntity<BookingEntity>(bookingEntity, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<BookingEntity> submitBooking(@RequestBody BookingEntity booking) {
		BookingEntity bookingEntity = (BookingEntity) bookingService.saveEntity(booking);
		return new ResponseEntity<BookingEntity>(bookingEntity, HttpStatus.OK);
	} 

	@RequestMapping(method = RequestMethod.DELETE, value = "/{bookingNo}")
	@ResponseBody
	public String cancelBooking(@PathVariable String bookingNo) {
		return "redirect:/bookings";
	}
}
