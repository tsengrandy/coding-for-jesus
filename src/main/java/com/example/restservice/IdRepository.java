package com.example.restservice;

import org.springframework.data.repository.CrudRepository;
import com.example.restservice.Ids;

public interface IdRepository extends CrudRepository<Ids, Long> {

}