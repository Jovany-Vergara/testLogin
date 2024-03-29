package com.example.demoLogin.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority

@Entity
@Table(name = 'USERS')
class User implements UserDetails {

  private static final long serialVersionUID = 1L;

  @Id
  String username
  String password
  String role
  Boolean enabled

    /**
     * @return the username
     */
  public String getUsername() {
    return username
  }

    /**
     * @param username the username to set
     */
  public void setUsername(String username) {
    this.username = username
  }

    /**
     * @return the password
     */
  public String getPassword() {
    return password
  }

    /**
     * @param password the password to set
     */
  public void setPassword(String password) {
    this.password = password
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(role));
    return authorities;
  }


    @Override
  public boolean isAccountNonExpired() {
    return true
  }

    @Override
  public boolean isAccountNonLocked() {
    return true
  }

    @Override
  public boolean isCredentialsNonExpired() {
    return true
  }

    @Override
  public boolean isEnabled() {
    return true
  }

    /*
     * (non-Javadoc)
     *
     * @see java.lang.Object#toString()
     */
    @Override
  public String toString() {
    return 'User [id=' + id + ', username=' + username + ', password=' + password + ']'
  }

}
