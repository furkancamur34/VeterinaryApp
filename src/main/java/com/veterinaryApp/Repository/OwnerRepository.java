package com.veterinaryApp.Repository;

import com.veterinaryApp.Owner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface OwnerRepository extends JpaRepository<Owner,Integer> {
}
