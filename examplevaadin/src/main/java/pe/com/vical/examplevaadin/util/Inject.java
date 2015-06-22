package pe.com.vical.examplevaadin.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
 
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Inject {
	
	static ApplicationContext applicationContext;
	
	public static void inject(Object object){
		if(applicationContext==null){
			ServletRequestAttributes requestAttributes = 
					(ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
			HttpServletRequest request=requestAttributes.getRequest();
			HttpSession session=request.getSession(false);
			applicationContext=WebApplicationContextUtils.getRequiredWebApplicationContext(session.getServletContext());
		}
		AutowireCapableBeanFactory beanFactory=applicationContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBeanProperties(object, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}
	
	public static void injectScheduler(Object object, ApplicationContext schedulerContext){
		if(applicationContext==null){
			applicationContext = schedulerContext;
		}
		AutowireCapableBeanFactory beanFactory=applicationContext.getAutowireCapableBeanFactory();
		beanFactory.autowireBeanProperties(object, AutowireCapableBeanFactory.AUTOWIRE_BY_NAME, false);
	}
}