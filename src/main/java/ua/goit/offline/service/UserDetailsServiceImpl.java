package ua.goit.offline.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ua.goit.offline.entity.Group;
import ua.goit.offline.entity.Role;

/**
 * Created by User on 14.08.2017.
 */
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ua.goit.offline.entity.User user = userService.getById(username);
        if (user==null) throw new UsernameNotFoundException("User not exists");
        String[] roles = user.getGroups().stream().map(Group::getRole).map(Enum::name).toArray(String[]::new);
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(roles)
//                .roles("User")
                .build();
    }
}
