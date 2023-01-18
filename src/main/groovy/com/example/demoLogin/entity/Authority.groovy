package com.example.demoLogin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'authorities')
class Authority {

  @Id
  String username
  String authority
}
