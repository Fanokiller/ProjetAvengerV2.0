package com.projetjava.appli;

import com.projetjava.appli.model.Identification;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.management.relation.Role;
import java.util.List;
import java.util.stream.Collectors;

public class IdentificationDetailService implements UserDetails {

    private String email;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public IdentificationDetailService(Identification identification) {
        this.email = identification.getEmail();
        this.password = identification.getPassword();
        this.active = identification.isActif();
        this.authorities = identification.getListeRole().stream()
                .map(Role::getRoleName)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}
