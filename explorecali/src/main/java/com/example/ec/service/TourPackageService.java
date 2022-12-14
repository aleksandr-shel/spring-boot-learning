package com.example.ec.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ec.domain.TourPackage;
import com.example.ec.repo.TourPackageRepository;

@Service
public class TourPackageService {
	
	@Autowired
	private TourPackageRepository tourPackageRepository;

	public TourPackageService(TourPackageRepository tourPackageRepository) {
		this.tourPackageRepository = tourPackageRepository;
	}
	
	public TourPackage createTourPackage(String code, String name) {

		return tourPackageRepository.findById(code)
				.orElse(tourPackageRepository.save(new TourPackage(code, name)));
	}
	
	public Iterable<TourPackage> lookup(){
		
		return tourPackageRepository.findAll();
	}
	
	public long total() {
		return tourPackageRepository.count();
	}
	
}