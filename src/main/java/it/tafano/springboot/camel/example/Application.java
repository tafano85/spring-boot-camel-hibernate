/**
 *
 */
package it.tafano.springboot.camel.example;

import static org.springframework.context.annotation.AdviceMode.ASPECTJ;

import org.apache.camel.spring.spi.SpringTransactionPolicy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author tafano
 *
 */
@SpringBootApplication
@EnableTransactionManagement(mode = ASPECTJ)
public class Application {

	public static final String PROPAGATION_MANDATORY = "PROPAGATION_MANDATORY";
	public static final String PROPAGATION_NESTED = "PROPAGATION_NESTED";
	public static final String PROPAGATION_NEVER = "PROPAGATION_NEVER";
	public static final String PROPAGATION_NOT_SUPPORTED = "PROPAGATION_NOT_SUPPORTED";
	public static final String PROPAGATION_REQUIRED = "PROPAGATION_REQUIRED";
	public static final String PROPAGATION_REQUIRES_NEW = "PROPAGATION_REQUIRES_NEW";
	public static final String PROPAGATION_SUPPORTS = "PROPAGATION_SUPPORTS";

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(name = PROPAGATION_MANDATORY)
	public SpringTransactionPolicy propagationMandatory(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_MANDATORY);
		return policy;
	}

	@Bean(name = PROPAGATION_NESTED)
	public SpringTransactionPolicy propagationNested(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_NESTED);
		return policy;
	}

	@Bean(name = PROPAGATION_NEVER)
	public SpringTransactionPolicy propagationNever(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_NEVER);
		return policy;
	}

	@Bean(name = PROPAGATION_NOT_SUPPORTED)
	public SpringTransactionPolicy propagationNotSupported(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_NOT_SUPPORTED);
		return policy;
	}

	@Bean(name = PROPAGATION_REQUIRED)
	public SpringTransactionPolicy propagationRequired(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_REQUIRED);
		return policy;
	}

	@Bean(name = PROPAGATION_REQUIRES_NEW)
	public SpringTransactionPolicy propagationRequiresNew(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_REQUIRES_NEW);
		return policy;
	}

	@Bean(name = PROPAGATION_SUPPORTS)
	public SpringTransactionPolicy propagationSupports(PlatformTransactionManager transactionManager) {
		SpringTransactionPolicy policy = new SpringTransactionPolicy();
		policy.setTransactionManager(transactionManager);
		policy.setPropagationBehaviorName(PROPAGATION_SUPPORTS);
		return policy;
	}

}