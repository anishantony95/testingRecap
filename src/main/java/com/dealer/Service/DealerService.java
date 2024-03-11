package com.dealer.Service;

import java.util.List;

import org.aspectj.lang.reflect.CatchClauseSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.dealer.DAO.DealerDAO;
import com.dealer.Entity.DealerEntity;
import com.dealer.Exception.CustomRatingException;
import com.dealer.Exception.NameNotFound;

@Service
public class DealerService {
	@Autowired
	DealerDAO ddao;

	public String add(DealerEntity s) throws CustomRatingException, NameNotFound {

		return ddao.exceadd(s);
	}

	public List<DealerEntity> findAll() {
		return ddao.findAll();
	}

	public List<DealerEntity> findRating() {
		return ddao.findRating();
	}

	public List<DealerEntity> getProduct(String name) {
		return ddao.getProduct(name);
	}

	public List<DealerEntity> getFirstName(String a) {
		return ddao.getfirstname(a);
	}

//	public List<DealerEntity> putValues ( int a) throws  CustomRatingException{
//		
//		if()
//		//a.stream().filter(x->x.getRating()<5).peek(x->x.throw new CustomRatingException("error"));
//		
//		return ddao.putValues(a);
//	}
	public String saveRating(int rate, int id) throws CustomRatingException {
		try {
			if (rate > 0 && rate < 6) {
				ddao.saveRating(rate, id);
				return "Success";
			} else {
				throw new CustomRatingException("Rating must be between 1 and 5 ");
			}

		} catch (CustomRatingException s) {
			return "Exception handled";
			// System.out.println("exception found");
		}

	}

	public String getByName(String name) throws NameNotFound {
		try {
			if (ddao.getByName(name).isEmpty())
				throw new NameNotFound("There is no name found");
			else
				ddao.getByName(name);
			return "Success";

		}

		catch (NameNotFound a) {
			return "Exception handeled tata bye";
		}

	}
}
