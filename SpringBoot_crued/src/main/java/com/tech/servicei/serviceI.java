package com.tech.servicei;

import java.util.List;
import java.util.Optional;

import org.springframework.expression.spel.ast.OpAnd;

import com.tech.entity.collage;

public interface serviceI {
	
	public String saveData(collage clg);
	
	public String savecollages(List<collage> clgs);
	
	public  Optional<collage>  getcollage(String cid);
	
	public String deleteData(String cid);
	
	public Optional<collage> update(collage clg);
	
	public List<collage> getAll();

}
