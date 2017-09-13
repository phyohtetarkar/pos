package com.jsoft.pos.repo;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import com.jsoft.pos.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	List<Payment> findByDeletedFalse(Sort sort);
}