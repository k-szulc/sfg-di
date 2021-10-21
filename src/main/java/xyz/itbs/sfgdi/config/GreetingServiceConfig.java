package xyz.itbs.sfgdi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.itbs.sfgdi.services.ConstructorGreetingService;
import xyz.itbs.sfgdi.services.PropertyGreetingService;
import xyz.itbs.sfgdi.services.SetterGreetingService;

@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyGreetingService propertyGreetingService(){
        return new PropertyGreetingService();
    }

    @Bean
    SetterGreetingService setterGreetingService(){
        return new SetterGreetingService();
    }

}
