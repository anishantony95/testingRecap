package com.dealer.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.dealer.Entity.DealerEntity;

public interface DealerRepo extends JpaRepository<DealerEntity, Integer> {
	@Query(value = "select * from dealer_table where rating>1", nativeQuery = true)
	public List<DealerEntity> findRating();
	
	
	//JPAquerry
	@Query(value="select e from DealerEntity e where e.product=:product")
	public List<DealerEntity> getProduct(@Param (value="product") String product);
	@Query(value="select e from DealerEntity e where e.name like \"?%\"")
	public List<DealerEntity> getfirstname(@Param (value="name") String name);
	@Query(value="update DealerEntity d set d.rating=:rate where id=:id")
	//public String saveRating(@Param (value="rate") int rate,@Param (value="id") int id);
	public String saveRating(@Param(value="rate")int rate,@Param (value="id") int id);
	@Query(value="select e from DealerEntity e where e.name=:name")
	public List<DealerEntity> getByName(@Param(value = "name") String name);
//	@Query(value="select e from DealerEntry e where e.product=:product")
//	public List<DealerEntity> getbyProduct(@Param(value ="product") String product);
}


