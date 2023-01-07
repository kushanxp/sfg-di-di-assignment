package guru.springframework.sfgdi;

import guru.springframework.sfgdi.config.SfgConfiguration;
import guru.springframework.sfgdi.controllers.*;
import guru.springframework.sfgdi.datasource.FakeDataSource;
import guru.springframework.sfgdi.services.PrototypeBean;
import guru.springframework.sfgdi.services.SingletonBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		PetController petController = ctx.getBean("petController", PetController.class);
		System.out.println("--- The Best Pet is ---");
		System.out.println(petController.whichPetIsTheBest());

		I18nController i18nController = (I18nController) ctx.getBean("i18nController");
		System.out.println(i18nController.sayHello());

		MyController myController = (MyController) ctx.getBean("myController");

		System.out.println("------- Primary Bean");
		System.out.println(myController.sayHello());

		System.out.println("------ Property");
		PropertyInjectedController propertyInjectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");
		System.out.println(propertyInjectedController.getGreeting());

		System.out.println("--------- Setter");
		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");
		System.out.println(setterInjectedController.getGreeting());

		System.out.println("-------- Constructor" );
		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");
		System.out.println(constructorInjectedController.getGreeting());

		System.out.println("----------Bean Scopes-----------");
		SingletonBean singletonBean = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean.getBeanScope());
		SingletonBean singletonBean2 = ctx.getBean(SingletonBean.class);
		System.out.println(singletonBean2.getBeanScope());

		PrototypeBean prototypeBean = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean.getBeanScope());
		PrototypeBean prototypeBean1 = ctx.getBean(PrototypeBean.class);
		System.out.println(prototypeBean1.getBeanScope());

		System.out.println("----------Property file values-----------");
		FakeDataSource fakeDataSource = (FakeDataSource) ctx.getBean("fakeDataSource");
		System.out.println(fakeDataSource.getUserName());
		System.out.println(fakeDataSource.getPassword());
		System.out.println(fakeDataSource.getJdbcUrl());

		System.out.println("-------ConfigurationProperties--------");
		SfgConfiguration sfgConfiguration = ctx.getBean(SfgConfiguration.class);
		System.out.println(sfgConfiguration.getUsername());
		System.out.println(sfgConfiguration.getPassword());
		System.out.println(sfgConfiguration.getJdbcUrl());

		System.out.println("--------- Conf Params-------------");
		FakeDataSource fake = (FakeDataSource) ctx.getBean("fakeDes");
		System.out.println(fake.getUserName());
		System.out.println(fake.getPassword());
		System.out.println(fake.getJdbcUrl());

		System.out.println("--------- Construction Params---------");
		FakeDataSource fake2 = (FakeDataSource) ctx.getBean("fakeDesConst");
		System.out.println(fake2.getUserName());
		System.out.println(fake2.getPassword());
		System.out.println(fake2.getJdbcUrl());
	}

}
