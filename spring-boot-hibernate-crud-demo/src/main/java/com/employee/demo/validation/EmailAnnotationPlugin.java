package com.employee.demo.validation;

import java.util.Optional;

import javax.validation.constraints.Email;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import springfox.bean.validators.plugins.Validators;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.schema.ModelPropertyBuilderPlugin;
import springfox.documentation.spi.schema.contexts.ModelPropertyContext;

@Component
@Order(Validators.BEAN_VALIDATOR_PLUGIN_ORDER)
public class EmailAnnotationPlugin implements ModelPropertyBuilderPlugin {
	@Override
	public boolean supports(DocumentationType delimiter) {
		return true;
	}

	@Override
	public void apply(ModelPropertyContext context) {
		Optional<Email> email = annotationFromBean(context, Email.class);
		if (email.isPresent()) {
			context.getBuilder().pattern(email.get().regexp());
			context.getBuilder().example("email@email.com");
		}
	}

	private Optional<Email> annotationFromBean(ModelPropertyContext context, Class<Email> class1) {
		// TODO Auto-generated method stub
		return null;
	}
}