package com.tech.reopository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tech.entity.collage;

@Repository
public interface myRepository extends CrudRepository<collage, String> {


}
