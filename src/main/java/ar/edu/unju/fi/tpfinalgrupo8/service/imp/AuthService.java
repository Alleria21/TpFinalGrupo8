package ar.edu.unju.fi.tpfinalgrupo8.service.imp;

import ar.edu.unju.fi.tpfinalgrupo8.entity.Ciudadano;
import ar.edu.unju.fi.tpfinalgrupo8.entity.Empleador;
import ar.edu.unju.fi.tpfinalgrupo8.repository.CiudadanoRepository;
import ar.edu.unju.fi.tpfinalgrupo8.repository.EmpleadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
@Service
public class AuthService implements UserDetailsService {
    @Autowired
    EmpleadorRepository empleadorRepository;
    @Autowired
    CiudadanoRepository ciudadanoRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Empleador> empleador = empleadorRepository.findByCuit(Long.parseLong(username));
        if(empleador.isPresent()) {
            List<? extends GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("EMPLEADOR"));
            return new User(String.valueOf(empleador.get().getCuit()), empleador.get().getPassword(), authorities);
        }
        Optional<Ciudadano> ciudadano = ciudadanoRepository.findByDni(Integer.parseInt(username));
        if(ciudadano.isPresent()){
            List<? extends GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("CIUDADANO"));
            return new User(String.valueOf(ciudadano.get().getDni()), ciudadano.get().getPassword(), authorities);
        }
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
