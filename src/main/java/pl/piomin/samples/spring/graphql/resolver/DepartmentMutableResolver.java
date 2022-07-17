package pl.piomin.samples.spring.graphql.resolver;

import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import pl.piomin.samples.spring.graphql.domain.Department;
import pl.piomin.samples.spring.graphql.domain.DepartmentInput;
import pl.piomin.samples.spring.graphql.domain.Organization;
import pl.piomin.samples.spring.graphql.repository.DepartmentRepository;
import pl.piomin.samples.spring.graphql.repository.OrganizationRepository;

//@Component
//public class DepartmentMutableResolver implements GraphQLMutationResolver {
@Controller
public class DepartmentMutableResolver {

	DepartmentRepository departmentRepository;
	OrganizationRepository organizationRepository;

	DepartmentMutableResolver(DepartmentRepository departmentRepository, OrganizationRepository organizationRepository) {
		this.departmentRepository = departmentRepository;
		this.organizationRepository = organizationRepository;
	}

	@MutationMapping
	public Department newDepartment(DepartmentInput departmentInput) {
		Organization organization = organizationRepository.findById(departmentInput.getOrganizationId()).get();
		return departmentRepository.save(new Department(null, departmentInput.getName(), null, organization));
	}

}
