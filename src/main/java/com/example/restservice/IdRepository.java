package com.example.restservice;

import org.springframework.data.repository.CrudRepository;
import com.example.restservice.MessageId;

public interface IdRepository extends CrudRepository<MessageId, Integer> {

}