package xyz.itbs.sfgdi.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import com.szu.pets.PetService;
import com.szu.pets.PetServiceFactory;
import xyz.itbs.sfgdi.datasource.FakeDataSource;
import xyz.itbs.sfgdi.repositories.EnglishGreetingRepository;
import xyz.itbs.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import xyz.itbs.sfgdi.services.*;

@ImportResource("classpath:sfgdi-config.xml")
@Configuration
public class GreetingServiceConfig {

    @Bean
    FakeDataSource fakeDataSource(@Value("${itbs.username}")String username,
                                  @Value("${itbs.password}")String password,
                                  @Value("${itbs.jdbcurl}")String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }

    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile("dog")
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat","default"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES","default"})
    @Bean("i18nService")
    I18nSpanishGreetingService i18nSpanishGreetingService(){
        return new I18nSpanishGreetingService();
    }

    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }

    @Profile("EN")
    @Bean
    I18nEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18nEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
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
