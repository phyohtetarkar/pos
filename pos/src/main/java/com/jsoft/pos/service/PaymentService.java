package com.jsoft.pos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Payment;
import com.jsoft.pos.repo.PaymentRepo;

@Service
@Transactional
public class PaymentService {

	@Autowired
    private PaymentRepo repo;
	
	public List<Payment> findAll() {
        return repo.findByIsDeletedFalse(new Sort("id"));
    }

    public Payment findById(int id) {
        return repo.findOne(id);
    }

    public void save(Payment payment) {
    		repo.save(payment);
    }

    public void delete(int id) {
        // TODO implement here
    }

}