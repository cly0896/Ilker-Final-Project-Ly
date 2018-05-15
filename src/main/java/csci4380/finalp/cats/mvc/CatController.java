/**
 * 
 */
package csci4380.finalp.cats.mvc;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import csci4380.finalp.cats.jpa.model.Cat;
import csci4380.finalp.cats.jpa.repo.CatRepository;

@Controller
@RequestMapping("/mvc/cat")
public class CatController {
	
	@Autowired
	private CatRepository catRepository;
	
	@RequestMapping(value="/echoMessage", method=RequestMethod.GET)
//	@RequestMapping("/echoMessage") 
//	@GetMapping("/echoMessage")		
	@ResponseBody					

	public String echoMessage(@RequestParam(value="msg", defaultValue="Hello") String message) {
		return "echoMessage echoed: " + message;
	}
	
	@GetMapping("/index4angular-hello")
	public String index4angular_hello() {
		return "index4angular-hello";
	}
	
	@GetMapping("/list")
	public String showCatList(Model model, @RequestParam(defaultValue="0") int page, @RequestParam(value="rowsPerPage", defaultValue="5") int size) {
		Page<Cat> catsPage = catRepository.findAll(new PageRequest(page, size));
		model.addAttribute("catsData", catsPage);
		model.addAttribute("currentPage", page);	// for UI nav-pills to high light "active" page
		model.addAttribute("rowsPerPage", size);	// example of passing 2 uri params
		return "catList";
	}
	
	// /mvc/student/save    POST
	@PostMapping("/save")   
	public String saveCat(Cat cat) {
		catRepository.save(cat);
		return "redirect:/mvc/cat/list";	// after cat is added, want to go to cat list view, so redirect to it's url
	}
	
	@GetMapping("/delete")
	public String deleteCat(Integer petId) {
		catRepository.deleteById(petId);
		return "redirect:/mvc/cat/list";	// after cat is deleted, want to go to cat list view, so redirect to it's url
	}
	
	@GetMapping("/detailOptional")
	@ResponseBody			
	public Optional<Cat> showCatDetailOptional(Integer petId) {
		return catRepository.findById(petId);
	}
	
	@GetMapping("/detail")	// /mvc/cat/detail
	@ResponseBody			
	public Cat showCatDetail(Integer petId) {
		Optional<Cat> cat = catRepository.findById(petId);
		return cat.isPresent() ? cat.get() : null;
	}
}
