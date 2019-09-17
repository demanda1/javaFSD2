package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.model.Contract;
import com.example.demo.model.Employee;
import com.example.demo.model.Permanent;
import com.example.demo.repository.ContractRepo;
import com.example.demo.repository.EmployeeRepo;
import com.example.demo.repository.PermanentRepo;


@Component
public class DevJpaBootstrap implements ApplicationListener<ContextRefreshedEvent> {

	private PermanentRepo permanentrepo;
	private EmployeeRepo emprepo;
	private ContractRepo contractrepo;
	
	public DevJpaBootstrap(PermanentRepo permanentrepo, EmployeeRepo emprepo, ContractRepo contractrepo) {
		super();
		this.permanentrepo = permanentrepo;
		this.emprepo = emprepo;
		this.contractrepo = contractrepo;
	}



	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}



	private void init() {
		// TODO Auto-generated method stub
		Employee emp =new Employee("John","Doe","johndoe@email.com");
		Permanent emp1=new Permanent("Deepak","Mandal","deepak@email.com",2000,200.0);
		Contract cnt1=new Contract("Subham","Agarwal","subham@email.com",100,"2 months");
		
		emprepo.save(emp);
		permanentrepo.save(emp1);
		contractrepo.save(cnt1);
		
	}

}
