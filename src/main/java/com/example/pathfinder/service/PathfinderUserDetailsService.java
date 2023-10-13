package com.example.pathfinder.service;

import com.example.pathfinder.model.entity.Role;
import com.example.pathfinder.model.entity.User;
import com.example.pathfinder.model.user.PathfinderUserDetail;
import com.example.pathfinder.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class PathfinderUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PathfinderUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() -> new UsernameNotFoundException(username + " not found!"));
    }

    private UserDetails map(User user) {
        return new PathfinderUserDetail(
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getRoles().stream().map(this::map)
                        .toList()
        );
    }

    private GrantedAuthority map(Role role) {
        return new SimpleGrantedAuthority("ROLE_" + role);
    }
}
