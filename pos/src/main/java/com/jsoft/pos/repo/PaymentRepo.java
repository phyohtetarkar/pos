package com.jsoft.pos.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {

}