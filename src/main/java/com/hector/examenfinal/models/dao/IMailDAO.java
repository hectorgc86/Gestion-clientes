package com.hector.examenfinal.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.hector.examenfinal.models.entity.Mail;

public interface IMailDAO extends CrudRepository<Mail, Long>{
	
}
