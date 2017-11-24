package app.utils.initialization;

import app.domain.Organization;
import app.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Gaidin on 24.11.2017.
 */
@Component
public class OrganizationInitializer extends Initializer {

    @Autowired
    OrganizationService organizationService;


    @Override
    public void initialize() {
        Organization organization0 = new Organization();
        organization0.setName("ООО 'Рога и копыта'");
        organization0.setInn("1212121212");
        organization0.setAddress("Тверь, ул.Советская д. 1 оф. 1");
        Organization organization1 = new Organization();
        organization1.setName("ИП 'Борисов'");
        organization1.setInn("985341256");
        organization1.setAddress("Тверь, ул Фрунзе д. 13");
        Organization organization2 = new Organization();
        organization2.setName("ООО 'Газпрём'");
        organization2.setInn("00000001");
        organization2.setAddress("Тверь, ул.Лениа д. 666 оф. 666");

        organizationService.addOrganization(organization0);
        organizationService.addOrganization(organization1);
        organizationService.addOrganization(organization2);
        System.out.println(organizationService.getAll());
    }
}

