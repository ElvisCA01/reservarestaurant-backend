package com.reserva.restaurant.reservarestaurantbackend;

import com.reserva.restaurant.reservarestaurantbackend.excepciones.UsuarioFoundException;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Rol;
import com.reserva.restaurant.reservarestaurantbackend.modelos.Usuario;
import com.reserva.restaurant.reservarestaurantbackend.modelos.UsuarioRol;
import com.reserva.restaurant.reservarestaurantbackend.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ReservarestaurantBackendApplication implements CommandLineRunner {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*").allowedMethods("GET", "POST","PUT", "DELETE");
            }
        };
    }

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


	public static void main(String[] args) {
		SpringApplication.run(ReservarestaurantBackendApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
            /*
         try {
             Usuario usuario = new Usuario();

             usuario.setNombre("Elvis");
             usuario.setApellido("Calderon");
             usuario.setUsername("elvis");
             usuario.setPassword(bCryptPasswordEncoder.encode("12345"));
             usuario.setEmail("ecalderona4@upao.edu.pe");
             usuario.setTelefono("945572200");
             usuario.setPerfil("foto.png");

             Rol rol = new Rol();
             rol.setRolID(1L);
             rol.setNombre("ADMIN");


             Set<UsuarioRol> usuarioRoles = new HashSet<>();
             UsuarioRol usuarioRol = new UsuarioRol();
             usuarioRol.setRol(rol);
             usuarioRol.setUsuario(usuario);
             usuarioRoles.add(usuarioRol);

             Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario, usuarioRoles);
             System.out.println(usuarioGuardado.getUsername());
         }catch (UsuarioFoundException exception){
             exception.printStackTrace();
         }*/

    }
}
