package com.german.gonzalez.productos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

/**
 * Componente para Establecer una Politica de Autenticación Personalizada sobre el Sistema
 * La Anotacion @Component indica que es un Componente del Sistema a ser levantado por el Sistema
 * @author German Gonzalez
 * @since 11-03-2019
 * @version 1.0.0
 *
 */
@Component
public class AuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

	/**
	 * Metodo que define el comportamiento del Sistema ante un error de Autenticacion
	 * La Anotacion @Override indica que es un metodo sobreescrito
	 * @author German Gonzalez
	 * @since 11-03-2019
	 * @version 1.0.0
	 * @param request Objeto HttpServletRequest que representa el Request de la Peticion
	 * @param response Objeto HttpServletResponse que representa el Response de la Peticion
	 * @param authEx Objeto AuthenticationException que representa la Excepcion de Autenticacion
	 * @throws IOException
	 * @throws ServletException
	 *
	 */
	@Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authEx) throws IOException, ServletException {
        
		response.addHeader("WWW-Authenticate", "Basic realm=" + getRealmName());
        
		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        
		PrintWriter writer = response.getWriter();
        
		writer.println("HTTP Status 401 - " + authEx.getMessage());
    
	}

	/**
	 * Metodo que establece el Realm de Autenticacion
	 * La Anotacion @Override indica que es un metodo sobreescrito
	 * @author German Gonzalez
	 * @since 11-03-2019
	 * @version 1.0.0
	 *
	 */
	@Override
    public void afterPropertiesSet() throws Exception {
        
		setRealmName("Sistema de Productos");
        
		super.afterPropertiesSet();
		
    }

}