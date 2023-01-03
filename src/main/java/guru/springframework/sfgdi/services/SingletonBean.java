package guru.springframework.sfgdi.services;

import org.springframework.stereotype.Service;

@Service
public class SingletonBean {

    public SingletonBean() {
        System.out.println("Creating a Singleton Bean !!!!!");
    }

    public String getBeanScope() {
        return ("I'm a Singleton bean");
    }
}
