package xyz.itbs.sfgdi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import xyz.itbs.sfgdi.controllers.*;
import xyz.itbs.sfgdi.datasource.FakeDataSource;
import xyz.itbs.sfgdi.services.DefaultBean;
import xyz.itbs.sfgdi.services.PrototypeBean;
import xyz.itbs.sfgdi.services.SingletonBean;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		System.out.println("-------- PetController");

		PetController petController = (PetController) ctx.getBean("petController");
		System.out.println(petController.getBest());


		System.out.println("-------- I18nController");

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());


		System.out.println("-------- MyController");
		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println(myController.getGreeting());

		System.out.println("-------- Property");
		PropertyInjectedController propertyInjectedController =
				(PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("-------- Setter");
		SetterInjectedController setterInjectedController =
				(SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor");
		ConstructorInjectedController constructorInjectedController =
				(ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());


		System.out.println("-------- Bean Scopes");
		DefaultBean singletonBean1 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean1.getMyScope());
		DefaultBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getMyScope());

		DefaultBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getMyScope());
		DefaultBean prototypeBean2 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean2.getMyScope());

		System.out.println("-------- Data Source");
		FakeDataSource fakeDataSource = ctx.getBean(FakeDataSource.class);
		System.out.println("DB Username :: " + fakeDataSource.getUsername());
		System.out.println("DB Password :: " + fakeDataSource.getPassword());
		System.out.println("DB URL :: " + fakeDataSource.getJdbcurl());

	}

}
