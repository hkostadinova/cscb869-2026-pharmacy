package org.informatics.cscb2026_pharmacy.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Getter
@Setter
public class Role extends BaseEntity implements GrantedAuthority {
    private String authority;
    @ManyToMany
    private Set<User> users;
}
