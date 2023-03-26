package com.Firadenda.FiradendaBack.repository;

import com.Firadenda.FiradendaBack.entity.Command;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CommandRepository extends JpaRepository<Command,Long> {
}
