package com.tech.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.entity.collage;
import com.tech.servicei.serviceI;

@RestController
public class collageController {
	@Autowired
	serviceI si;
	@PostMapping("collage/add")
	public ResponseEntity<String> addtrain(@RequestBody collage clg)
	{
		
		String resp = si.saveData(clg);
		return new ResponseEntity<String>(resp,HttpStatus.CREATED);
		
	}
	@PostMapping("collages/addall")
	public ResponseEntity<String> addCollages(@RequestBody  List<collage> clgs)
	{
		
		String restmsg = si.savecollages(clgs);
		return  new ResponseEntity<String>(restmsg,HttpStatus.CREATED);
		
	}
	
	@GetMapping("collage/{cid}")
	public ResponseEntity<Object>getcollage(@PathVariable("cid")String cid)
	{
		Optional<collage> clg = si.getcollage(cid);
		if(clg.isPresent())
		{
			return new ResponseEntity<Object>(clg,HttpStatus.ACCEPTED);
			
		}
		return new ResponseEntity<Object>("collageid:"+cid+"does not exist",HttpStatus.NOT_FOUND);
			
	}
	@DeleteMapping("collage/{cid}")
	public ResponseEntity<String> deletecollage(@PathVariable("cid") String cid)
	{
		String msg = si.deleteData(cid);
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
		
	}
	@PutMapping("collage/update")
	public ResponseEntity<Object>updatedata(@RequestBody collage clg)
	{ 
		
		Optional<collage> option = si.update(clg);
		if(option.isPresent())
		{
			return new ResponseEntity<Object>("data updated successfully",HttpStatus.CREATED);

		}
		return new ResponseEntity<Object>(clg.getC_id()+"record not found" ,HttpStatus.CREATED);
		
	}
	@GetMapping("collage/getall")
	public ResponseEntity <List<collage> >getAllData(@RequestBody collage clg)
	{
		List<collage> all = si.getAll();
		
		return new ResponseEntity<List<collage>>(all,HttpStatus.OK);
	}

}
