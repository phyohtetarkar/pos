package com.jsoft.pos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsoft.pos.entity.Payment;
import com.jsoft.pos.repo.PaymentRepo;

@Service
public class PaymentService {

	@Autowired
    private PaymentRepo repo;

    public Payment findById(int id) {
        // TODO implement here
        return null;
    }

    public void save(Payment payment) {
        // TODO implement here
    }

    public void delete(int id) {
        // TODO implement here
    }

}