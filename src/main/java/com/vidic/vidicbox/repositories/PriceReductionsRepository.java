package com.vidic.vidicbox.repositories;

import com.vidic.vidicbox.models.PriceReductions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriceReductionsRepository extends JpaRepository<PriceReductions,Long> {
}
