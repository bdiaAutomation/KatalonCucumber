package objectsDomain;

import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

import java.util.Locale;
import java.util.Map;

import cucumber.api.TypeRegistry;
import cucumber.api.TypeRegistryConfigurer;

public class DataTableTypeTransformer implements TypeRegistryConfigurer {

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {
		registry.defineDataTableType(new DataTableType(Customer.class, new TableEntryTransformer<Customer>() {
			@Override
			public Customer transform(Map<String, String> entry) {
				return new Customer(entry.get("email"), entry.get("password"));
			}
		}));

	}

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

}