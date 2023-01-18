package com.example.demoLogin.service

import org.springframework.stereotype.Service
import com.example.demoLogin.entity.User
import spock.lang.Specification
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import com.example.demoLogin.repository.UserRepository

@SpringBootTest
class UserServiceSpec extends Specification {

  @Autowired
  UserService userService
  @Autowired
  UserRepository userRepository

  def "Spec 0 check service inject"() {
    expect:
    assert userService
  }

  @Transactional
  def "Create user if not exist"() {
    given: "Name and password"
      String name = "diegoJovanyTest"
      String password = "holamnudo"
      User user = new User(name: name, password: password)
    when: "Executing service"
      Boolean result = userService.createUser(user)
    then:
      result
  }

  @Transactional
  def "Not Create user if exists"() {
    given: "A user eixts"
      String name = "diegoJovanyTest"
      String password = "holamnudo"
      User user = new User(name: name, password: password)
      userRepository.save(user) // Ya existe el usuario
    when: "Executing service"
      Boolean result = userService.createUser(user)
    then:
      result == false
  }

  @Transactional
  def "Elimited user by id"(){
    given: "existen user"
    User user = new User(name: "Diego", password: "Test");
    userService.createUser(user)
    when: "Delete user"
    userRepository.deleteByName("Diego")
    User userExists = userRepository.findByUsername("Diego")
    then:
    userExists == null
  }
}
