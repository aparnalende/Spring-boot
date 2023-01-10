package com.demo.aparna.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.context.annotation.Bean;
//
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//

@SpringBootApplication
public class ZonionBackendProjectApplication {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
//	
//	@Autowired 
//	private UserDetailsRepository userDetailsRepo;
//	

	public static void main(String[] args) {
		SpringApplication.run(ZonionBackendProjectApplication.class, args);
		System.out.println("I am in main method");
	}

//	@Bean
//	public Docket apiDocket() {
//		 return new Docket(DocumentationType.SWAGGER_2).select()
//		         .apis(RequestHandlerSelectors.basePackage("com.demo.aparna.project")).build();
//		   }
}
//	@PostConstruct
//	protected void init() {
//		List<Authorities> authorities=new ArrayList<>();
//		
//		authorities.add(createAuthority("USER","User-role"));
//		authorities.add(createAuthority("ADMIN","Admin-role"));
//	
//	User user=new User();
////	user.setUserName("admin");
////	user.setFirstName("admin");
////	user.setLastName("admin");
////	user.setPassword(passwordEncoder.encode("admin@123"));
////	user.setEnabled(true);
//	user.setAuthorities(authorities);
//	
//	userDetailsRepo.save(user);
//	
//	}

//	private Authorities createAuthority(String roleCode,String roleDescription) {
//		Authorities authorities=new Authorities();
//		authorities.setRoleCode(roleCode);
//		authorities.setRoleDescription(roleDescription);
//		return authorities;
//	}
