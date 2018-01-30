/**
 *
 */
package it.tafano.springboot.camel.example.route;

import static it.tafano.springboot.camel.example.Application.PROPAGATION_NOT_SUPPORTED;
import static it.tafano.springboot.camel.example.Application.PROPAGATION_REQUIRES_NEW;

import org.apache.camel.spring.SpringRouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import it.tafano.springboot.camel.example.processor.BlankProcessor;
import it.tafano.springboot.camel.example.processor.Processor1;
import it.tafano.springboot.camel.example.processor.Processor2;
import it.tafano.springboot.camel.example.processor.Processor3;

/**
 * @author tafano
 *
 */
@Component
public class ExampleRouter extends SpringRouteBuilder {

	@Autowired
	BlankProcessor blankProcessor;

	@Autowired
	Processor1 processor1;

	@Autowired
	Processor2 processor2;

	@Autowired
	Processor3 processor3;

	@Override
	public void configure() throws Exception {
		// @formatter:off
		from("direct:processor1")
				.onException(Exception.class).markRollbackOnlyLast().end()
				.transacted(PROPAGATION_REQUIRES_NEW)
				.process(processor1)
				.policy(PROPAGATION_NOT_SUPPORTED)
				.to("direct:processor2")
				.end();

		from("direct:processor2")
				.onException(Exception.class).markRollbackOnlyLast().end()
				.transacted(PROPAGATION_REQUIRES_NEW)
				.process(processor2)
				.policy(PROPAGATION_NOT_SUPPORTED)
				.to("direct:processor3")
				.end();

		from("direct:processor3")
				.onException(Exception.class).markRollbackOnlyLast().end()
				.transacted(PROPAGATION_REQUIRES_NEW)
				.process(processor3)
				.policy(PROPAGATION_NOT_SUPPORTED)
				.stop()
				.end();
		// @formatter:on
	}

}