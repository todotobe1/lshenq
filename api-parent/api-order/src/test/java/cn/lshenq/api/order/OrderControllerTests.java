
package cn.lshenq.api.order;

import static org.junit.Assert.assertEquals;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.client.Traverson;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.web.WebAppConfiguration;

//@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ApiOrderApplication.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
@DirtiesContext
public class OrderControllerTests {

	@Value("${local.server.port}")
	private int port;

//	@Test
	public void envEndpointNotHidden() throws Exception {
		Traverson traverson = new Traverson(new URI("http://localhost:" + this.port + "/orders"), MediaTypes.HAL_JSON);
		String orderContent = traverson.follow("self").toObject("$.orderNo");
		assertEquals("Your order no: 1!", orderContent);
	}
}