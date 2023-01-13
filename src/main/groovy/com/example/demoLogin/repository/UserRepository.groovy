package com.example.demoLogin.repository

import com.example.demoLogin.entity.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.domain.Sort

@Repository
interface UserRepository extends CrudRepository<User, Integer> {

  User findByName(String name)
  List<User> findAll()
  void deleteByName(String name)

}
