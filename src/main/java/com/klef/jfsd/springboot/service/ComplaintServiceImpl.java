package com.klef.jfsd.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.jfsd.springboot.model.Complaint;
import com.klef.jfsd.springboot.repository.ComplaintRepo;

@Service
public class ComplaintServiceImpl implements ComplaintService{
	
	@Autowired
	private ComplaintRepo complaintrepo;
	
	@Override
	public String addcomplaint(Complaint c) {
		 complaintrepo.save(c);
		 return "Complaint Added Successfully";
	}

}
