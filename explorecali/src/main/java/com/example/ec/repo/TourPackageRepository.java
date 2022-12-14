package com.example.ec.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.ec.domain.TourPackage;

//spring implements repository interfaces for us
//creates objects and injects them into services
//RepositoryRestResource renames endpoint from the default that generated
@RepositoryRestResource(collectionResourceRel="packages", path="packages")
public interface TourPackageRepository extends CrudRepository<TourPackage,String> {
	Optional<TourPackage> findByName(String name);

//	@Override
	//RestResource controlling API exposure,
	//Restrict access from outside world
//	@RestResource(exported = false)
//	default <S extends TourPackage> S save(S entity) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	//RestResource controlling API exposure,
	//Restrict access from outside world
	@RestResource(exported = false)
	default <S extends TourPackage> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@RestResource(exported = false)
	default void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void delete(TourPackage entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAllById(Iterable<? extends String> ids) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll(Iterable<? extends TourPackage> entities) {
		// TODO Auto-generated method stub
		
	}

	@Override
	@RestResource(exported = false)
	default void deleteAll() {
		// TODO Auto-generated method stub
		
	}
	
	
}
