package com.uprep.userms.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.uprep.userms.entity.Currency;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency, Long> {

	List<Currency> findAll();
	Currency findCurrencyById(Long currency);
}
