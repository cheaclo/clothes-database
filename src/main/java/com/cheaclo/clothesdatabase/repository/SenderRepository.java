package com.cheaclo.clothesdatabase.repository;

import com.cheaclo.clothesdatabase.entity.Sender;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SenderRepository extends JpaRepository<Sender, Long> {
    Sender findFirstByNameIgnoreCase(String name);
}
