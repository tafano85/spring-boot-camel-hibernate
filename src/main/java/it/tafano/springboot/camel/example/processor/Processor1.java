/**
 *
 */
package it.tafano.springboot.camel.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.tafano.springboot.camel.example.entity.ExampleEntity;
import it.tafano.springboot.camel.example.repository.ExampleRepository;

/**
 * @author tafano
 *
 */
@Component
public class Processor1 implements Processor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExampleRepository exampleRepository;

	public void process(Exchange exchange) throws Exception {
		log.info("{} BEGIN", this.getClass().getSimpleName());

		ExampleEntity exampleEntity = new ExampleEntity();
		exampleEntity.setCode("code1");
		exampleEntity.setDescription("description1");
		exampleRepository.addExampleEntity(exampleEntity);

		log.info("{} inserted.", exampleEntity);
		log.info("{} END", this.getClass().getSimpleName());
	}

}
