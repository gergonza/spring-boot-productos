package com.german.gonzalez.productos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Componente para Establecer un Entorno de Seguridad sobre el Sistema
 * La Anotacion @Configuration indica que el Componente forma parte de la Configuracion del Sistema
 * @author German Gonzalez
 * @since 11-03-2019
 * @version 1.0.0
 *
 */
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * Metodo para Configurar el Tipo de Autenticacion a utilizar para el Sistema (se establece HTTP Basico)
	 * La Anotacion @Override indica que es un metodo sobreescrito de la clase de la cual hereda el componente
	 * @author German Gonzalez
	 * @since 11-03-2019
	 * @version 1.0.0
	 * @throws Exception
	 *
	 */
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
		http
         	.csrf().disable()
         	.authorizeRequests().anyRequest().authenticated()
         	.and()
         	.httpBasic();
    
	}

	/**
	 * Metodo para establecer la Configuracion Global de Autenticacion del Sistema
	 * La Anotacion @Autowired indica los Beans que seran inyectados para la realizacion de las Pruebas
	 * @author German Gonzalez
	 * @since 11-03-2019
	 * @version 1.0.0
	 * @throws Exception
	 *
	 */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        
    	auth.inMemoryAuthentication()
            .withUser("admin")
            .password("{noop}password")
            .roles("USER","ADMIN");
    	
    }

}