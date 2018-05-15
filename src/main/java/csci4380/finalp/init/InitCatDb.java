/**
 * 
 */
package csci4380.finalp.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;

@Component
public class InitCatDb implements CommandLineRunner {

	private CatRepository catRepository;
	
	@Autowired
	public InitCatDb(CatRepository catRepository) {
		super();
		this.catRepository = catRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Cat catUno = new Cat("Mittens", "Tabby", "Tom Feld", "285 Madison Avenue", 21, true, "2018-05-04");
		//Cat catUno = new Cat(3, "285 Madison Avenue", 21, true, "Mango", "Tom Feld", "tabby", "05/04/2018");
		Cat savedCatUno = catRepository.save(catUno);
		System.out.println("Save catUno");
	}

}
