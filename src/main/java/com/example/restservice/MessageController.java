package com.example.restservice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.restservice.IdRepository;

@RestController
public class MessageController { 
	
	@Autowired 
  	private IdRepository idRepository;

	@PostMapping(path="/add") // Map ONLY POST Requests
  	public @ResponseBody String addNewUser (@RequestBody Message message) {

    MessageId n = new MessageId(message.getId());
    idRepository.save(n);
    return "Saved";
  }

	// @PostMapping("/message")
	// public WordCount message(@RequestBody Message message) {
	// 	// [x] break down message into id and message
	// 	private int id = message.getId();
	// 	private String msg = message.getMessage();
	// 	 // [] check IDtable if id exists already
	// 	 // [] if so, return TOTALtable word count
	// 	 // [x] check if message is empty
	// 	 if(msg.isBlank()) {
	// 		 // [] if so, return TOTALtable word count

	// 	} else {
	// 		// [x] if not, splice message to find word count
	// 		String[] words = msg.trim().split("\\s+");
	// 		int wordCount = words.length;
	// 	 }
	// 	 // [] add up TOTALtable word count with message word count
	// 	 // [] store new value into TOTALtable word count
	// 	 // [] return that word count

	// 	// if (ids.contains(message.getId())) {
	// 	// 	System.out.println("Id already exists: " + message.getId());
	// 	// 	return new WordCount(counter.get());
	// 	// } else {
	// 	// 	ids.add(message.getId());
	// 	// 	String[] words = message.getMessage().trim().split("\\s+");
	// 	// 	return message.getMessage().isBlank() 
	// 	// 	? new WordCount(counter.get()) 
	// 	// 	: new WordCount(counter.addAndGet(words.length));
	// 	// }
	// }
}