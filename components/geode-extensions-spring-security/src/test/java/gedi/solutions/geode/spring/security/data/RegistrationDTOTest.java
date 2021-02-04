package gedi.solutions.geode.spring.security.data;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrationDTOTest
{

	@Test
	public void testToUserDetails()
	{
		RegistrationDTO dto = new RegistrationDTO();
		dto.setPassword("password".toCharArray());
		dto.setUserName("nyla");
		dto.setFirstName("FirstName");
		dto.setLastName("LastName");
		
		UserProfileDetails details = dto.toUserDetails("READ");
		assertNotNull(details);
		assertEquals(details.getUsername(),"nyla");
		assertEquals(details.getPassword(),details.getPasswordEncoder()+"password");
		assertEquals(details.getFirstName(),"FirstName");
		assertEquals(details.getLastName(),"LastName");
		
		assertTrue(details
		.getAuthorities()
		.stream().anyMatch(a -> "READ".equals(a.getAuthority())));
		
	}

}
