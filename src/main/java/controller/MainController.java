package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import db.*;
import org.hibernate.Session;
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
		if (nurse_id == 0) {
			model.addAttribute("button_value", "Add");
			return "nurse_edit";	
		}
		else{
			model.addAttribute("button_value", "Edit");
			return "nurse_edit";
		}
	}
	
	@RequestMapping(value = "/station_edit", method = RequestMethod.GET)
	public String stationEdit(ModelMap model) {
		//model.addAttribute("message", "Hi , Spring 3 MVC Hello World");
		return "station_edit";
	}
	
	@RequestMapping(value = "/nurse_add", method = RequestMethod.POST)
	public String nurseAdd(ModelMap model, @RequestParam String edit_button, @RequestParam String name) {
		if(edit_button.equals("Add")) {
			
			TNurse nurse = new TNurse(); 
			nurse.setName("ATai"); 
			java.util.Date now = new java.util.Date();
			java.sql.Timestamp sqlDate = new java.sql.Timestamp(now.getTime());
			nurse.setTimeStamp(sqlDate); 
	        // 開啟Session，相當於開啟JDBC的Connection
	        Session session = HibernateUtil.getSessionFactory().openSession();
	        System.out.println("開啟完成");
	        // Transaction表示一組會話操作
	        Transaction tx= session.beginTransaction(); 
	        // 將物件映射至資料庫表格中儲存
	        session.save(nurse);
	        tx.commit(); 
	        session.close();
	        
	        HibernateUtil.shutdown();
			
			return "nurse_edit";
		}
		else {
			// EDIT NURSE DATA
			System.out.println("新增失敗");
			System.out.println(edit_button);
			return "nurse_edit";
		}
	}
	
	@RequestMapping(value = "/station_add", method = RequestMethod.GET)
	public String stationAdd(ModelMap model) {
		//model.addAttribute("message", "Hi , Spring 3 MVC Hello World");
		return "station_edit";
	}
	
	
}
