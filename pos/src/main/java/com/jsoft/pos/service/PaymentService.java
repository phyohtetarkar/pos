package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jsoft.pos.entity.Payment;
import com.jsoft.pos.repo.PaymentRepo;

@Service
@Transactional
public class PaymentService {

	@Autowired
    private PaymentRepo repo;

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