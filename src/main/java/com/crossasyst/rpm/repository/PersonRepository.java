package com.crossasyst.rpm.repository;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {


    List<PersonEntity> findByActiveTrue();

    @Override
    @Modifying
    @Query("UPDATE PersonEntity SET active = false WHERE  personId = ?1")
    void deleteById(Long personId);
}
