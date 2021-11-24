package apap.tutorial.emsidi.security;

import apap.tutorial.emsidi.model.UserModel;
import apap.tutorial.emsidi.repository.UserDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailPasswordServiceImpl implements UserDetailsPasswordService {
    @Autowired
    private UserDb userDb;

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) throws UsernameNotFoundException {
        UserModel userModel = userDb.findByUsername(user.getUsername());
        userModel.setPassword(newPassword);
        return userDetailsService.loadUserByUsername(user.getUsername());
    }
}
