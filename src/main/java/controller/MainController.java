package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import db.*;
import org.hibernate.Session;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;


@Controller
@RequestMapping("/Main")
public class MainController {
	@RequestMapping("")
	public String mainController() {
		return "menu";
	}
	
	@RequestMapping(value = "/nurse_list", method = RequestMethod.GET)
	public String nurseList(ModelMap model) {
		model.addAttribute("abc", "123");
		return "list";
	}
	
	@RequestMapping(value = "/station_list", method = RequestMethod.GET)
	public String stationList(ModelMap model) {
		//model.addAttribute("message", "Hi , Spring 3 MVC Hello World");
		return "list";
	}
	
	@RequestMapping(value = "/nurse_edit", method = RequestMethod.GET)
	public String nurseEdit(ModelMap model, @RequestParam int nurse_id) {
		//model.addAttribute("message", "Hi , Spring 3 MVC Hello World");
		if (nurse_id == 0)
			model.addAttribute("button_value", "Add");
		else
			model.addAttribute("button_value", "Edit");
		return "nurse_edit";
	}
	
	@RequestMapping(value = "/station_edit", method = RequestMethod.GET)
	public String stationEdit(ModelMap model, @RequestParam int station_id) {
		if (station_id == 0) 
			model.addAttribute("button_value", "Add");
		else
			model.addAttribute("button_value", "Edit");
		return "station_edit";
	}
	
	@RequestMapping(value = "/nurse_add", method = RequestMethod.POST)
	public String nurseAdd(ModelMap model, @RequestParam String edit_button, @RequestParam String name) {
		if(edit_button.equals("Add")) {
			
			TNurse nurse = new TNurse(); 
			nurse.setName(name); 
			nurse.setAddtime(new java.sql.Timestamp(new java.util.Date().getTime())); 
	        // 開啟Session，相當於開啟JDBC的Connection
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        // Transaction表示一組會話操作
	        Transaction tx= session.beginTransaction(); 
	        // 將物件映射至資料庫表格中儲存
	        session.save(nurse);
	        tx.commit(); 
	        
	        Criteria criteria = session.createCriteria(User.class);
	        List users = criteria.list();
	                
	        for(Iterator it = users.iterator(); it.hasNext(); ) {
	            User user = (User) it.next();
	            System.out.println(user.getId() +
	                                     " \t " + user.getName() +
	                                  "/" + user.getAge());    
	        } 
	        session.close();
	        
			return "list";
		}
		else {
			return "list";
		}
	}
	
	@RequestMapping(value = "/station_add", method = RequestMethod.POST)
	public String stationAdd(ModelMap model, @RequestParam String edit_button, @RequestParam String name) {
		if(edit_button.equals("Add")){
			TStation station = new TStation(); 
			station.setName(name);
			station.setAddtime(new java.sql.Timestamp(new java.util.Date().getTime())); 
	        // 開啟Session，相當於開啟JDBC的Connection
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        // Transaction表示一組會話操作
	        Transaction tx= session.beginTransaction(); 
	        // 將物件映射至資料庫表格中儲存
	        session.save(station);
	        tx.commit(); 
	        session.close();
			return "list";
		}
		else 
			return "list";

	}
}
