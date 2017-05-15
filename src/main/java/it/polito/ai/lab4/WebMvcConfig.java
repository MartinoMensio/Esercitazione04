package it.polito.ai.lab4;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import it.polito.ai.lab4.web.interceptors.CompleteProfileInterceptor;

@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {
  @Autowired 
  private CompleteProfileInterceptor completeProfileInterceptor;

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
	  // TODO enable the check on user profile info
	  
	  /*registry.addInterceptor(completeProfileInterceptor)
	  			.addPathPatterns("/**")
	  			.excludePathPatterns("/profile");*/
  }
}
