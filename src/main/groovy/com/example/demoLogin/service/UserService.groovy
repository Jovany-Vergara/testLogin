package com.example.demoLogin.service

import org.springframework.stereotype.Service
import com.example.demoLogin.entity.User
import org.springframework.beans.factory.annotation.Autowired
import com.example.demoLogin.repository.UserRepository
import com.example.demoLogin.entity.User

@Service
class UserService {

  @Autowired
  UserRepository userRepository

  Boolean createUser(User user){
    User userExist = userRepository.findByName(user.name)
    if(!userExist) {
      userRepository.save(user)
      return true
    }
    false
  }
}
