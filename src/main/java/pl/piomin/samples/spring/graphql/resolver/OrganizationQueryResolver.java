package pl.piomin.samples.spring.graphql.resolver;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pl.piomin.samples.spring.graphql.domain.Organization;
import pl.piomin.samples.spring.graphql.repository.OrganizationRepository;

//@Component
//public class OrganizationQueryResolver implements GraphQLQueryResolver {
@Controller
public class OrganizationQueryResolver {

	private OrganizationRepository repository;

	OrganizationQueryResolver(OrganizationRepository repository) {
		this.repository = repository;
	}

	@QueryMapping
	public Iterable<Organization> organizations() {
		return repository.findAll();
	}

	public Organization organization(Integer id) {
		return repository.findById(id).orElseThrow();
	}
}
