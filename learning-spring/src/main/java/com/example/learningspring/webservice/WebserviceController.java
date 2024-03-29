package com.example.learningspring.webservice;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learningspring.business.GuestService;
import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;
import com.example.learningspring.business.RoomService;
import com.example.learningspring.data.Guest;
import com.example.learningspring.data.Room;
import com.example.learningspring.util.DateUtils;

@RestController
@RequestMapping("/api")
public class WebserviceController {

	private final DateUtils dateUtils;
	private final ReservationService reservationService;
	private GuestService guestService;
	private final RoomService roomService;
	public WebserviceController(DateUtils dateUtils, ReservationService reservationService, GuestService guestService,
			RoomService roomService) {
		super();
		this.dateUtils = dateUtils;
		this.reservationService = reservationService;
		this.guestService = guestService;
		this.roomService = roomService;
	}
	
	@RequestMapping(path="/reservations",method=RequestMethod.GET)
	public List<RoomReservation> getReservations(@RequestParam(name="date", required=false) String date){
		return reservationService.getRoomReservationsForDate(dateUtils.createDateFromDateString(date));
	}
	
	@PostMapping("/guests")
	public ResponseEntity<Guest> postGuest(@RequestBody Guest guest) {
		
//		Guest addguest = new Guest(guest.getFirstName(), guest.getLastName(), guest.getEmailAddress(),
//				guest.getAddress(),guest.getCountry(),guest.getState(),guest.getPhoneNumber());
//		
		Guest newGuest = guestService.addGuest(guest);
		
		return new ResponseEntity<>(newGuest, HttpStatus.OK);
	}
	
	@GetMapping("/rooms")
	public List<Room> getRooms(){
		return roomService.getRooms();
	}
}
