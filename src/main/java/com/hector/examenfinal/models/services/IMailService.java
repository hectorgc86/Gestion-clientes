package com.hector.examenfinal.models.services;

import java.util.List;

import com.hector.examenfinal.models.entity.Mail;

public interface IMailService {

	public List<Mail> findAll();
	
	public Mail save(Mail mail);
	
	public Mail findById(Long id);
	
	public void delete(Long id);
}
