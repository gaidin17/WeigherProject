package app;

import app.utils.port.ComPortManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import app.utils.initialization.InitialisationServise;


/**
 * Created by Gaidin on 12.11.2017.
 */
@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        InitialisationServise initialisationServise = context.getBean(InitialisationServise.class);
        ComPortManager comPortManager = context.getBean(ComPortManager.class);
        initialisationServise.init();
        comPortManager.startReadData();
    }
}
