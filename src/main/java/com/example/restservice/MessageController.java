package com.example.restservice;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
	/** 
	 * break down message into id and message
	 * check IDtable if id exists already
	 * if so, return TOTALtable word count
	 * if not, check if message is empty
	 * if so, return TOTALtable word count
	 * if not, splice message to find word count
	 * add up TOTALtable word count with message word count
	 * store new value into TOTALtable word count
	 * return that word count
	*/

	private final AtomicInteger counter = new AtomicInteger();
	private final ArrayList<Integer> ids = new ArrayList<Integer>();

	@PostMapping("/message")
	public WordCount message(@RequestBody Message message) {
		if (ids.contains(message.getId())) {
			System.out.println("Id already exists: " + message.getId());
			return new WordCount(counter.get());
		} else {
			ids.add(message.getId());
			String[] words = message.getMessage().trim().split("\\s+");
			return message.getMessage().isBlank() 
			? new WordCount(counter.get()) 
			: new WordCount(counter.addAndGet(words.length));
		}
	}
}