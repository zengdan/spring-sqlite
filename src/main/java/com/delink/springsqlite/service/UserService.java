package com.delink.springsqlite.service;

import com.delink.springsqlite.bean.User;
import com.delink.springsqlite.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @Classname UserService
 * @Description TODO
 * @Autor cengdan
 * @Date 2023/7/3123:10
 * @Version 1.0
 */
@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  public User getUserByID(Long id) {
    return userRepository.findById(id).get();
  }

  public User getByName(String name) {
    return userRepository.findByName(name);
  }

  public Page<User> findPage() {
    Pageable pageable = PageRequest.of(0, 10);
    return userRepository.findAll(pageable);
  }

  public Page<User> find(Long maxId) {
    Pageable pageable = PageRequest.of(0, 10);
    return userRepository.findMore(maxId, pageable);
  }

  public User save(User u) {
    return userRepository.save(u);
  }

  public User update(Long id, String name) {
    User user = userRepository.findById(id).get();
    user.setName(name + "_update");
    return userRepository.save(user);
  }

  public Boolean updateById(String name, Long id) {
    return userRepository.updateById(name, id) == 1;
  }
}
