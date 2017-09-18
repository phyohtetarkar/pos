package com.jsoft.pos.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsoft.pos.entity.Invoice;

public interface InvoiceRepo extends JpaRepository<Invoice, Long>, SearchableRepository<Invoice> {

	@Query("select t from Invoice t where t.deleted = ?1 and t.trade.eventDate between ?2 and ?3")
	List<Invoice> findByEventDate(boolean deleted, LocalDate dateFrom, LocalDate dateTo, Pageable pagable);
}