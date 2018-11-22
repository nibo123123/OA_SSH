package chencj.cc.oa.listener;

import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import chencj.cc.oa.entity.Privilege;
import chencj.cc.oa.service.PrivilegeService;

public class OAInit implements ServletContextListener{

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//获取spring容器
		WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(sce.getServletContext());
		PrivilegeService privilegeService = (PrivilegeService) applicationContext.getBean("privilegeServiceImpl");
		List<Privilege> topList = privilegeService.findTop();
		applicationContext.getServletContext().setAttribute("privilegeList", topList);
	}

}
