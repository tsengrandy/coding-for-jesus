package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

	private final AtomicLong counter = new AtomicLong();
	private final ArrayList<Integer> ids = new ArrayList<Integer>();

	@PostMapping("/message")
	public WordCount message(@RequestBody Message message) {
		if (ids.contains(message.getId())) {
			return new WordCount(counter.get());
		} else {
			ids.add(message.getId());
			String[] words = message.getMessage().split("\\s");
			return new WordCount(counter.addAndGet(words.length));
		}
	}
}
//assuming you can't send empty messages