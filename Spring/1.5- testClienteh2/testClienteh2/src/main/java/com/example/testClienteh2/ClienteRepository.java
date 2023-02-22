package com.example.testClienteh2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;

public interface ClienteRepository extends JpaRepository<Cliente,Long> {
}
