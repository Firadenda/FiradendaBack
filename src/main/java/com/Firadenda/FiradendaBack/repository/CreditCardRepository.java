package com.Firadenda.FiradendaBack.repository;

import com.Firadenda.FiradendaBack.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CreditCardRepository extends JpaRepository<CreditCard,Long> {
}
