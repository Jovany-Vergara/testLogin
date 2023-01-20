package com.example.demoLogin.service

import org.springframework.stereotype.Service
import com.example.demoLogin.entity.User
import org.springframework.beans.factory.annotation.Autowired
import com.example.demoLogin.repository.UserRepository
import com.example.demoLogin.entity.User
import org.springframework.transaction.annotation.Transactional
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Service
class UserService {

  @Autowired
  UserRepository userRepository

  Boolean createUser(User user){
    BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
    String pwd = bcryptPasswordEncoder.encode(user.password);
    user.password = pwd
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
