/**
 *
 */
package it.tafano.springboot.camel.example;

import java.util.List;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import it.tafano.springboot.camel.example.entity.ExampleEntity;
import it.tafano.springboot.camel.example.repository.ExampleRepository;

/**
 * @author tafano
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableAutoConfiguration
public class ExampleTest {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CamelContext camelContext;

	@Autowired
	private ExampleRepository exampleRepository;

	@Test
	public void testExample() throws Exception {
		try {
			log.info("Start example test.");
			ProducerTemplate template = camelContext.createProducerTemplate();
			template.sendBody("direct:processor1", "Test");
		} catch (Exception e) {
			log.warn(e.getMessage(), e);
		}

		log.info("Check results.");
		List<ExampleEntity> foundList = exampleRepository.getAllExampleEntitys();
		log.info("Result: {}", foundList);
		Assert.assertNotNull(foundList);
		Assert.assertFalse(foundList.isEmpty());
		Assert.assertNotNull(foundList.get(0));
		Assert.assertEquals("code2", foundList.get(0).getCode());
	}

}
