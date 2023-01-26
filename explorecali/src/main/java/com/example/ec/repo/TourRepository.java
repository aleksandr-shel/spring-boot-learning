package com.example.ec.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.ec.domain.Difficulty;
import com.example.ec.domain.Region;
import com.example.ec.domain.Tour;


//spring implements repository interfaces for us
//creates objects and injects them into services
//PagingAndSortingRepository provides implementation for paging:
//size (20), page (0), sort (default by id, asc,desc)
public interface TourRepository extends CrudRepository<Tour, Integer>, PagingAndSortingRepository<Tour, Integer>{
	
	//Pageable method returns Page and has pageable parameter
	Page<Tour> findByTourPackageCode(@Param("code")String code, Pageable pageable);

	//this
	@Query("Select t from Tour t where t.tourPackage.code = ?1 " +
	"and t.difficulty = ?2 and t.region = ?3 and t.price <= ?4")
	List<Tour> lookupTour(String code, Difficulty difficulty, Region region,
			Integer maxPrice);
	
	//same as
	List<Tour> findByTourPackageCodeAndDifficultyAndRegionAndPriceLessThan(
			String code, Difficulty difficulty, Region region,
			Integer maxPrice);
	
//	@Override
//	@RestResource(exported=false)
	//RestResource controlling API exposure,
	//Restrict access from outside world
//	default <S extends Tour> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	//RestResource controlling API exposure,
	//Restrict access from outside world
	@RestResource(exported=false)
	default <S extends Tour> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RestResource(exported=false)
	default void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported=false)
	default void delete(Tour entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported=false)
	default void deleteAllById(Iterable<? extends Integer> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported=false)
	default void deleteAll(Iterable<? extends Tour> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported=false)
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	

}
