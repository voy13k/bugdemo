package bug.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class BugdemoApplicationTests {

	@Autowired
	MockMvc mockApi;

	@Test
	void testGet() throws Exception {
		mockApi.perform(
				MockMvcRequestBuilders.get("/api")
						.contentType(MediaType.APPLICATION_JSON)
						.with(SecurityMockMvcRequestPostProcessors.jwt()))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}

}
