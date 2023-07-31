package com.delink.springsqlite.dao;

import com.delink.springsqlite.bean.User;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByName(String name);

  @Query("select u from User u where u.id <= ?1")
  Page<User> findMore(Long maxId, Pageable pageable);

  @Modifying
  @Transactional
  @Query("update User u set u.name = ?1 where u.id = ?2")
  int updateById(String name, Long id);
}
