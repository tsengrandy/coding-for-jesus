package com.example.restservice;

import org.springframework.data.repository.CrudRepository;
import com.example.restservice.TotalWordCount;

public interface WordCountRepository extends CrudRepository<TotalWordCount, Long> {

}