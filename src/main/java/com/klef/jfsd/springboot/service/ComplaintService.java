package com.klef.jfsd.springboot.service;

import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;

@Service
public interface ComplaintService {
	
	public String addcomplaint(Complaint c);
	
}
