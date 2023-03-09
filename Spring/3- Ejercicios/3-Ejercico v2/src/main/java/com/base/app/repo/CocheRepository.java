package com.base.app.repo;

import com.base.app.Coche;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CocheRepository extends JpaRepository<Coche,Long> {
}
