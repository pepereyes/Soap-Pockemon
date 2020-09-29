package com.bankaya.pokemon.request.logging;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RequestLoggingRepository extends JpaRepository<RequestLogging, Long>{

}
