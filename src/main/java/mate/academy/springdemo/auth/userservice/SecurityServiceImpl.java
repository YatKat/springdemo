package mate.academy.springdemo.auth.userservice;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public String findLoggedInUsername() {
        Object userDetails = SecurityContextHolder.getContext().getAuthentication().getDetails();
        if(userDetails instanceof UserDetails){
            return ((UserDetails) userDetails).getUsername();
        }
        return null;
    }

    @Override
    public void autologin(String username, String password) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken
                (userDetails, password, userDetails.getAuthorities());
        authenticationManager.authenticate(token);
        if (token.isAuthenticated()) {
            SecurityContextHolder.getContext().setAuthentication(token);
            log.debug(String.format("Auto login %s successfully!", username));
        }

    }

//    @Override
//    public void doLogin(UserLoginInput userLoginInput) {
//        UserDetails userDetails = userDetailsService.loadUserByUsername(userLoginInput.getLogin());
//        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, userLoginInput.getPassword(), userDetails.getAuthorities());
//        Authentication authentication = authenticationManager.authenticate(token);
//        if (token.isAuthenticated()) {
//            System.out.println("We are authenticated");
//            UserDetails principal = (UserDetails) authentication.getPrincipal();
//        }
//    }
}
