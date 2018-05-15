package csci4380.finalp.dogs.mongodb.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.dogs.mongodb.model.Dog;;

@Repository
//public interface DogRepository extends MongoRepository<Dog, String>, QuerydslPredicateExecutor<Dog> {
public interface DogRepository extends MongoRepository<Dog, String> {
	public Optional<List<Dog>> findByPetId(Integer petId);
	public Optional<List<Dog>> findByAgeLessThan(int age);
	public Optional<List<Dog>> findByNameOrOwnerNameOrderByAgeDesc(String name, String ownerName);
	public Optional<List<Dog>> findFirst3ByAddress(String address);
	public Optional<List<Dog>> findByNameStartingWith(String name);
	public Optional<List<Dog>> findByNameOrOwnerName(String name, String ownerName);
	//public void deleteByPetId(Integer petId);
	
	public void deleteByPetId(Integer petId);
	
	@Query("{}")
	public List<Dog> findMyAll();
	@Query("{'name': ?0}")
	public List<Dog> findMyByName(String name);
	@Query("{'name': {$regex: ?0}}")
	public List<Dog> findMyByNameRegexp(String regexp);
	@Query("{'age': {$gt: ?0, $lt: ?1}}")
	public List<Dog> findMyByAgeBetween(int ageGT, int ageLT);
	
    public Optional<List<Dog>> findByTypeAllIgnoreCase(@Param("type") String dogType);
}
