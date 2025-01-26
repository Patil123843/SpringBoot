package com.tech.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tech.entity.collage;
import com.tech.reopository.myRepository;
import com.tech.servicei.serviceI;

@Service
public class serviceImpl implements serviceI {
	@Autowired
	myRepository repo;

	@Override
	public String saveData(collage clg) {
   System.out.println("clg----------->"+clg.getC_name());
  String str1= clg.getC_name();
  if(str1==" ")
  {
	  System.out.println("printed...............................");
	  repo.save(clg);
  }
		//repo.save(clg);

		return "collageid" + clg.getC_id() + "added Succsefully";
	}

	@Override
	public String savecollages(List<collage> clgs) {

		repo.saveAll(clgs);

		return "All Collages add succefully";
	}

	@Override
	public Optional<collage> getcollage(String cid) {
		Optional<collage> getclg = repo.findById(cid);

		return getclg;
	}

	@Override
	public String deleteData(String cid) {
		Optional<collage> id = repo.findById(cid);
		if (id.isPresent()) {
			collage collage = id.get();

			repo.deleteById(cid);
			return "data deleted succesfully";
		}
		return cid + "record not found";

	}

	@Override
	public Optional<collage> update(collage clg) {
		Optional<collage> ids = repo.findById(clg.getC_id());
		if (ids.isPresent()) {
			repo.save(clg);

			return ids;
		}

		return ids;
	}

	@Override
	public List<collage> getAll() {
		Iterable<collage> all = repo.findAll();
		
		return (List<collage>) all;
	}

}
