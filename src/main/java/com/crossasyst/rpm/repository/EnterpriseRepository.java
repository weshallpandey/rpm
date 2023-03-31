package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnterpriseRepository extends JpaRepository<EnterpriseEntity, Long> {



}
