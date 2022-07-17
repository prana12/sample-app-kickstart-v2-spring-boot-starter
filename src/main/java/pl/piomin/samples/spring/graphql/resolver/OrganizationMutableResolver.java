package pl.piomin.samples.spring.graphql.resolver;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pl.piomin.samples.spring.graphql.domain.Organization;
import pl.piomin.samples.spring.graphql.domain.OrganizationInput;
import pl.piomin.samples.spring.graphql.repository.OrganizationRepository;

//@Component
//public class OrganizationMutableResolver implements GraphQLMutationResolver {
@Controller
public class OrganizationMutableResolver {

	OrganizationRepository repository;

	OrganizationMutableResolver(OrganizationRepository repository) {
		this.repository = repository;
	}

	@MutationMapping
	public Organization newOrganization(OrganizationInput organizationInput) {
		return repository.save(new Organization(null, organizationInput.getName(), null, null));
	}

}
