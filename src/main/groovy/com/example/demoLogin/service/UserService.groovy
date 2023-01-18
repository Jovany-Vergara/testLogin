package com.example.demoLogin.service

import org.springframework.stereotype.Service
import com.example.demoLogin.entity.User
import org.springframework.beans.factory.annotation.Autowired
import com.example.demoLogin.repository.UserRepository
import com.example.demoLogin.entity.User
import org.springframework.transaction.annotation.Transactional

@Service
class UserService {

  @Autowired
  UserRepository userRepository

  Boolean createUser(User user){
    User userExist = userRepository.findByUsername(user.username)
    if(!userExist) {
      userRepository.save(user)
      return true
    }
    false
  }

  @Transactional
  def deleteByUsername(String username){
    userRepository.deleteByUsername(username)
  }

}
