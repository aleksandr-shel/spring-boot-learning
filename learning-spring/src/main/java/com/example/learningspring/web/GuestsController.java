package com.example.learningspring.web;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.learningspring.business.GuestService;
import com.example.learningspring.data.Guest;

@Controller
@RequestMapping("/guests")
public class GuestsController {

	private GuestService guestService;
	
	public GuestsController(GuestService guestService) {
		this.guestService = guestService;
	}
	
	@GetMapping
	public String getGuests(Model model) {
		Iterable<Guest> guests = guestService.getGuests();
		
		model.addAttribute("guests", guests);
		
		return "guests";
	}
	
}