package com.dealer.DAO;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.dealer.Entity.DealerEntity;
import com.dealer.Exception.CustomRatingException;
import com.dealer.repo.DealerRepo;

@Repository
public class DealerDAO {
	@Autowired
	DealerRepo dr;

	public String add(List<DealerEntity> s) {

		dr.saveAll(s);

		return "SavedSuccesfully";

	}

	public List<DealerEntity> findAll() {
		return dr.findAll();
	}

	public List<DealerEntity> findRating() {
		return dr.findRating();
	}

	public List<DealerEntity> getProduct(String name) {
		return dr.getProduct(name);
	}

	public List<DealerEntity> getfirstname(String a) {
		return dr.getfirstname(a);
	}

//	public List<DealerEntity> putValues( int a)throws  CustomRatingException{
//		return dr.saveAll(a);
//	}
	public String saveRating(int rate, int id) {

		return dr.saveRating(rate, id);
	}

	public String exceadd(DealerEntity s) throws CustomRatingException {
		try {
			if (s.getRating() >= 1 && s.getRating() <= 5) {
				dr.save(s);
				return "SavedSuccesfully";
			} else
				throw new CustomRatingException("Rating must be between 1 and 5 ");
		} catch (CustomRatingException p) {
			return "Exception handled";
			// System.out.println("exception found");
		}
	}

	public List<DealerEntity> getByName(String name) {
		return dr.getByName(name);

	}

}
