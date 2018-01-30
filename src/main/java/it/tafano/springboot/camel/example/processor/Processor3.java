/**
 *
 */
package it.tafano.springboot.camel.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author tafano
 *
 */
@Component
public class Processor3 implements Processor {

	private final Logger log = LoggerFactory.getLogger(this.getClass());

	public void process(Exchange exchange) throws Exception {
		log.info("{} BEGIN", this.getClass().getSimpleName());

		throw new UnsupportedOperationException("Fake exception");
	}

}
