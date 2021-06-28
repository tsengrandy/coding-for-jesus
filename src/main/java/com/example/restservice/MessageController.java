package com.example.restservice;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.restservice.IdRepository;
import com.example.restservice.WordCountRepository;

@RestController
public class MessageController { 

	@Autowired 
	private IdRepository idRepository;
	  
	@Autowired 
  	private WordCountRepository wordCountRepository;

	private boolean doesRepoExist(WordCountRepository repo){
		return repo.count() != 0;
	}

	@PostMapping(path="/message")
	public TotalWordCount addNewCount(@RequestBody Message message) {
		long id = message.getId();
		String msg = message.getMessage();

		if(idRepository.existsById(id)){
			return wordCountRepository.findById(wordCountRepository.count()).get();
		}
		idRepository.save(new Ids(id));

		if(msg.isBlank()) {
			return doesRepoExist(wordCountRepository) 
			? wordCountRepository.findById(wordCountRepository.count()).get()
			: wordCountRepository.save(new TotalWordCount(0));
		} 
		
		long wordCount = msg.trim().split("\\s+").length;
		long newWordCount = doesRepoExist(wordCountRepository) 
		? wordCountRepository.findById(wordCountRepository.count()).get().getCount() + wordCount
		: wordCount;

		return wordCountRepository.save(new TotalWordCount(newWordCount));
	}
}