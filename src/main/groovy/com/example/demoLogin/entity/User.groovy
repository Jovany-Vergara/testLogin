package com.example.demoLogin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'USERS')
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id
  String name
  String password
}