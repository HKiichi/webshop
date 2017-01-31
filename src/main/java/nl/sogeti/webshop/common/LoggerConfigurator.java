package nl.sogeti.webshop.common;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import java.util.logging.Logger;

/**
 * Created by ikikuchi on 16-1-2017.
 */
public class LoggerConfigurator {

    @Produces
    public Logger get (InjectionPoint ip){
        Class<?> requestingClass = ip.getMember().getDeclaringClass();
        return Logger.getLogger(requestingClass.getName());
    }
}
