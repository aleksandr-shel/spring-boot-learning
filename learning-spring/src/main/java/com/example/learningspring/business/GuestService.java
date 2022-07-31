package com.example.learningspring.business;

import java.util.Comparator;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.learningspring.data.Guest;
import com.example.learningspring.data.GuestRepository;

@Service
public class GuestService {

	private final GuestRepository guestRepository;
	public GuestService(GuestRepository guestRepository) {
		this.guestRepository = guestRepository;
	}
	
	public Iterable<Guest> getGuests(){
		List<Guest> guests = (List<Guest>) guestRepository.findAll();
		guests.sort(new Comparator<Guest>() {

			@Override
			public int compare(Guest o1, Guest o2) {
				if (o1.getLastName().equals(o2.getLastName())) {
					return o1.getFirstName().compareTo(o2.getFirstName());
				}
				
				return o1.getFirstName().compareTo(o2.getFirstName());
			}
			
		});
		return guestRepository.findAll();
	}
	
	public Guest addGuest(Guest guest) {
		if (null == guest) {
			throw new RuntimeException("guest cannot be null");
		}
		Guest res = guestRepository.save(guest);
		return res;
	}
}
