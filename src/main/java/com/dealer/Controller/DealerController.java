package com.dealer.Controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dealer.Entity.DealerEntity;
import com.dealer.Exception.CustomRatingException;
import com.dealer.Exception.NameNotFound;
import com.dealer.Service.DealerService;

@RestController
//@RequestMapping("/Dealer")
public class DealerController {
	@Autowired
	DealerService ds;
	static Logger log =Logger.getLogger(DealerController.class);

	@PostMapping("/add")
	public String add(@RequestBody DealerEntity s) throws CustomRatingException, NameNotFound {
		return ds.add(s);
	}

	@GetMapping("/findAll")
	public List<DealerEntity> findAll() {
		PropertyConfigurator.configure("log4j-2.properties");
		log.info(ds.findAll());
		
		return ds.findAll();
	}

	@GetMapping("/findRating")
	public List<DealerEntity> findRating() {
		return ds.findRating();
	}

	@GetMapping("/getproduct/{name}")
	public List<DealerEntity> getProduct(@PathVariable String name) {
		return ds.getProduct(name);
	}

	@GetMapping("/getfirstName/{a}")
	public List<DealerEntity> getFirstName(@PathVariable String a) {
		return ds.getFirstName(a);
	}

	@PostMapping(value = "/saveRating/{rate}/{id}")
	public String saveRating(@PathVariable int rate, @PathVariable int id) throws CustomRatingException {
		return ds.saveRating(rate, id);
	}

	@GetMapping(value = "/setByName/{name}")
	public String getByName(@PathVariable String name) throws NameNotFound {
		return ds.getByName(name);
	}

}
