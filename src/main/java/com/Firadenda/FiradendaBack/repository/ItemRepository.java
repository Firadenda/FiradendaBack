package com.Firadenda.FiradendaBack.repository;

import com.Firadenda.FiradendaBack.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;

@EnableJpaRepositories
public interface ItemRepository extends JpaRepository<Item,Long> {
}
