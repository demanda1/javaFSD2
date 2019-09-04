package com.mycompany.springannotations;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext();
    	context.scan("com.mycompany.springannotations");
    	context.refresh();
        SwinCoach sw=context.getBean(SwinCoach.class);
        System.out.println(sw.getEmail()+" "+sw.getTeamName());
        System.out.println(sw.getService());
        
        SwinCoach sw2=(SwinCoach)context.getBean("sc2");
        System.out.println(sw2.getEmail()+"--"+sw.getTeamName());
        
        ClassPathXmlApplicationContext con=new ClassPathXmlApplicationContext("applicationContext.xml");
        EmployeeDao dao=con.getBean("edao", EmployeeDao.class);
        dao.createEmployee(new Employee("Sourav"));
    }
}
