package com.app.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.Membership;

@Repository
public interface MembershipRepository extends JpaRepository<Membership, Integer> {

}
