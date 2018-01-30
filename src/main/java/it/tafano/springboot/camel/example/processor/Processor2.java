/**
 *
 */
package it.tafano.springboot.camel.example.processor;

import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import it.tafano.springboot.camel.example.entity.ExampleEntity;
import it.tafano.springboot.camel.example.repository.ExampleRepository;

/**
 * @author tafano
 *
 */
@Component
public class Processor2 implements Processor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private ExampleRepository exampleRepository;

	public void process(Exchange exchange) throws Exception {
		log.info("{} BEGIN", this.getClass().getSimpleName());

		List<ExampleEntity> exampleEntityList = exampleRepository.getAllExampleEntitys();
		log.info("{} found.", exampleEntityList);
		Assert.notEmpty(exampleEntityList, "no exampleEntity found");
		for (ExampleEntity exampleEntity : exampleEntityList) {
			exampleEntity.setCode("code2");
			exampleEntity.setDescription("description2");
			exampleRepository.updateExampleEntity(exampleEntity);
			log.info("{} updated.", exampleEntity);
		}

		log.info("{} END", this.getClass().getSimpleName());
	}

}
