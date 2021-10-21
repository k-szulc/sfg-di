package xyz.itbs.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean implements DefaultBean{

    public SingletonBean(){
        System.out.println("SfgDI :: SingletonBean :: Creating the bean");
    }

    @Override
    public String getMyScope(){
        return "SfgDI :: SingletonBean :: SINGLETON BEAN";
    }
}
