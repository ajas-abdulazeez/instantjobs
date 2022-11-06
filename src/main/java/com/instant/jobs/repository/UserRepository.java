package com.instant.jobs.repository;

import com.instant.jobs.entity.Accounts;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<Accounts,Integer> {
    Accounts findByUserName(String username);

    Accounts findByuserNameAndPassword(String userName, String password);

    Accounts findUserById(int id);
}
