package mate.academy.springdemo.auth.userservice;

import lombok.extern.log4j.Log4j2;
import mate.academy.springdemo.auth.usermodel.Role;
import mate.academy.springdemo.auth.usermodel.User;
import mate.academy.springdemo.auth.userrepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Set;

@Service
@Log4j2
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findUserByUsername(username);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();
        for(Role role : user.getRoles()){
            log.debug("-----------------------------------------------"+role);//not shown in logs
            grantedAuthoritySet.add(new SimpleGrantedAuthority(role.getName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), grantedAuthoritySet);
    }
}
