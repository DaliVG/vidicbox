package com.vidic.vidicbox.repositories;

import com.vidic.vidicbox.models.Suppliers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SuppliersRepository extends JpaRepository<Suppliers,Long> {
}
