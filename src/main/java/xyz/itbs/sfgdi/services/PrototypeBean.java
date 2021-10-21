package xyz.itbs.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class PrototypeBean implements DefaultBean {

    public PrototypeBean() {
        System.out.println("SfgDI :: PrototypeBean :: Creating the bean");
    }

    @Override
    public String getMyScope() {
        return "SfgDI :: PrototypeBean :: PROTOTYPE BEAN";
    }
}
