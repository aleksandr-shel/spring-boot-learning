package com.example.learningspring.web;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.learningspring.business.ReservationService;
import com.example.learningspring.business.RoomReservation;
import com.example.learningspring.util.DateUtils;

@Controller
@RequestMapping("/reservations")
public class RoomReservationController {
	private final DateUtils dateUtils;
	private final ReservationService reservationsService;
	public RoomReservationController(DateUtils dateUtils, ReservationService reservationsService) {
		super();
		this.dateUtils = dateUtils;
		this.reservationsService = reservationsService;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String getReservation(@RequestParam(value="date", required=false)String dateString, Model model) {
		
		Date date = this.dateUtils.createDateFromDateString(dateString);
		List<RoomReservation> roomReservations = this.reservationsService.getRoomReservationsForDate(date);
		model.addAttribute("roomReservations",roomReservations);
		
		return "roomres";
	}
}
