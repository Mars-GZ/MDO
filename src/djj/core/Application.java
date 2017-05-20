package djj.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mesmers on 2017/4/16.
 */
public class Application {

    private static ApplicationContext context;

    public static synchronized ApplicationContext getApplicationContext(){
        if (context==null)
            context = new ClassPathXmlApplicationContext("classpath:/info/applicationContext.xml");
        return context;
    }

}
