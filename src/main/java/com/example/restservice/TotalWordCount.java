package com.example.restservice;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TotalWordCount {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	private long count;

	public TotalWordCount() {}

	public TotalWordCount(long count) {
		this.count = count;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}
}