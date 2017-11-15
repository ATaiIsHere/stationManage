package controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import db.*;
import org.hibernate.Session;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


@Controller
@RequestMapping("/Main")
public class MainController {
	@RequestMapping("")
	public String mainController() {
		return "menu";
	}
	
	@RequestMapping(value = "/nurse_list", method = RequestMethod.GET)
	public String nurseList(ModelMap model) {
		model.addAttribute("listype_id", "員編");
		String showlist = new String();
		Session session = HibernateUtil.getSessionFactory().openSession();
		List nurselist = session.createQuery("from TNurse").getResultList();
		session.close();
		for(Iterator it = nurselist.iterator(); it.hasNext(); ) {
            TNurse nurse = (TNurse) it.next();
            showlist += "<tr><td>" + nurse.getNurse_id().toString() + "</td>"
            		+ "<td>" + nurse.getName() + "</td>"
            		+ "<td>" + nurse.getAddtime().toString() + "</td>"
            		+ "<td><form action=\"nurse_edit\" method=\"POST\"><input type=\"hidden\" name=\"nurse_id\" value=" + nurse.getNurse_id().toString() + "><input type=\"submit\" value=\"View\"></form>"
            		+ "<form action=\"nurse_del\" method=\"POST\"><input type=\"hidden\" name=\"nurse_id\" value=" + nurse.getNurse_id().toString() + "><input type=\"submit\" value=\"Del\"></form></td></tr>";
        }
		model.addAttribute("showlist", showlist);
		return "list";
	}
	
	@RequestMapping(value = "/station_list", method = RequestMethod.GET)
	public String stationList(ModelMap model) {
		model.addAttribute("listype_id", "站編");
		String showlist = new String();
		Session session = HibernateUtil.getSessionFactory().openSession();
		List nurselist = session.createQuery("from TStation").getResultList();
		session.close();
		for(Iterator it = nurselist.iterator(); it.hasNext(); ) {
			TStation station = (TStation) it.next();
            showlist += "<tr><td>" + station.getStation_id().toString() + "</td>"
            		+ "<td>" + station.getName() + "</td>"
            		+ "<td>" + station.getAddtime().toString() + "</td>"
            		+ "<td><form action=\"station_edit\" method=\"POST\"><input type=\"hidden\" name=\"station_id\" value=" + station.getStation_id().toString() + "><input type=\"submit\" value=\"View\"></form>"
            		+ "<form action=\"station_del\" method=\"POST\"><input type=\"hidden\" name=\"station_id\" value=" + station.getStation_id().toString() + "><input type=\"submit\" value=\"Del\"></form></td></tr>";
        }
		model.addAttribute("showlist", showlist);
		return "list";
	}
	
	@RequestMapping(value = "/nurse_edit")
	public String nurseEdit(ModelMap model, @RequestParam Long nurse_id) {
		//model.addAttribute("message", "Hi , Spring 3 MVC Hello World");
		if (nurse_id == 0) {
			model.addAttribute("button_value", "Add");
			model.addAttribute("nurse_id", "0");
			model.addAttribute("name", "");
			Session session = HibernateUtil.getSessionFactory().openSession();
			List stationlist = session.createQuery("from TStation").getResultList();
			session.clear();
			String assigned = new String("");
			String stationpool = new String("");
			for(Iterator it = stationlist.iterator(); it.hasNext(); ) {
				TStation station = (TStation) it.next();
				stationpool += "<option value=\"" + station.getStation_id().toString() + "-" + station.getName() + "\">" + station.getStation_id().toString() + "-" + station.getName() + "</option>";
	        }
			model.addAttribute("assigned", assigned);
			model.addAttribute("stationpool", stationpool);
		}
		else {
			model.addAttribute("button_value", "Edit");
			Session session = HibernateUtil.getSessionFactory().openSession();
			List nurselist = session.createQuery("from TNurse where nurse_id="+nurse_id.toString()).getResultList();
			TNurse nurse = (TNurse)nurselist.get(0);
			model.addAttribute("nurse_id", nurse.getNurse_id().toString());
			model.addAttribute("name", nurse.getName());
			List stationlist = session.createQuery("from TStation").getResultList();
			List assignedlist = session.createQuery("from TAssignment where nurse_id="+nurse.getNurse_id().toString()+" and expired=0").getResultList();
			session.clear();
			String assigned = new String("");
			String stationpool = new String("");
			for(Iterator sit = stationlist.iterator(); sit.hasNext(); ) {
				TStation station = (TStation) sit.next();
				Boolean have = new Boolean("False");
				for(Iterator ait = assignedlist.iterator(); ait.hasNext(); ) {
					TAssignment assignment = (TAssignment) ait.next();
					if(station.getStation_id() == assignment.getStation_id()) {
						have = new Boolean("True");
						break;
					}
				}
				if(have)
					assigned += "<option value=\"" + station.getStation_id().toString() + "-" + station.getName() + "\">" + station.getStation_id().toString() + "-" + station.getName() + "</option>";
				else
					stationpool += "<option value=\"" + station.getStation_id().toString() + "-" + station.getName() + "\">" + station.getStation_id().toString() + "-" + station.getName() + "</option>";
	        }
			model.addAttribute("assigned", assigned);
			model.addAttribute("stationpool", stationpool);
		}
		return "nurse_edit";
	}
	
	@RequestMapping(value = "/station_edit")
	public String stationEdit(ModelMap model, @RequestParam Long station_id) {
		if (station_id == 0) {
			model.addAttribute("button_value", "Add");
			model.addAttribute("name", "");
			model.addAttribute("showlist", "");
		}
		else {
			model.addAttribute("button_value", "Edit");
			Session session = HibernateUtil.getSessionFactory().openSession();
			List stationlist = session.createQuery("from TStation where station_id="+station_id.toString()).getResultList();
			TStation station = (TStation)stationlist.get(0);
			model.addAttribute("station_id", station.getStation_id().toString());
			model.addAttribute("name", station.getName());
			String showlist = "<a>站點護士列表</a><br><table><tr><th>編號</th><th>名字</th></tr>";
			List<Long> nurseidlist = (List<Long>)session.createQuery("select nurse_id from TAssignment where station_id="+station_id.toString()+" and expired=0").getResultList();
			for(Long nurse_id:nurseidlist) {
				String name = (String)session.createQuery("select name from TNurse where nurse_id="+nurse_id).getSingleResult();
				showlist += "<tr><td>" + nurse_id + "</td><td>" + name + "</td></tr>";
			}
			showlist += "</table>";
			model.addAttribute("showlist", showlist);
		}
		return "station_edit";
	}
	
	@RequestMapping(value = "/nurse_add")
	public ModelAndView nurseAdd(ModelMap model, @RequestParam String edit_button, @RequestParam String name, 
			@RequestParam String nurse_id,
			@RequestParam("assigned[]") String[] assigned, @RequestParam("stationpool[]") String[] stationpool) {
        // 開啟Session，相當於開啟JDBC的Connection
		Session session = HibernateUtil.getSessionFactory().openSession();
		if(edit_button.equals("Add")) {
			TNurse nurse = new TNurse(); 
			nurse.setName(name); 
			nurse.setAddtime(new java.sql.Timestamp(new java.util.Date().getTime()));
	        // Transaction表示一組會話操作
	        Transaction tx= session.beginTransaction(); 
	        // 將物件映射至資料庫表格中儲存
	        session.save(nurse);
	        tx.commit();
	        nurse_id = String.valueOf(session.createQuery("select MAX(nurse_id) from TNurse").getSingleResult());
	        tx= session.beginTransaction();
	        for(String station:assigned) {
	        	if(station.equals(""))
	        		continue;
	        	else{
	        		String[] station_info = station.split("-");
	        		Long station_id = Long.valueOf(station_info[0]);
	        		String station_name = station_info[1];
	        		TAssignment assignment = new TAssignment(); 
	        		assignment.setStation_id(station_id);
	        		assignment.setNurse_id(Long.valueOf(nurse_id));
	        		assignment.setAddtime(new java.sql.Timestamp(new java.util.Date().getTime()));
	        		assignment.setExpired(new Boolean("False"));
	        		session.save(assignment);
	        	}
	        }
	        tx.commit();
		}
		else {
			Transaction tx= session.beginTransaction();
			session.createQuery("update TNurse set name='"+name+"',addtime='"+new java.sql.Timestamp(new java.util.Date().getTime()).toString()+"' where nurse_id="+nurse_id).executeUpdate();
			List<TAssignment> assignedlist = (List<TAssignment>)session.createQuery("from TAssignment where nurse_id="+nurse_id+" and expired=0").getResultList();
			Boolean[] reassigned = new Boolean[assigned.length];
			Boolean[] relist = new Boolean[assignedlist.size()];
			Arrays.fill(reassigned, Boolean.FALSE);
			Arrays.fill(relist, Boolean.FALSE);
			int i=0;
			for(String station:assigned) {
				if(station.equals(""))
					continue;
				String[] station_info = station.split("-");
				Long station_id = Long.valueOf(station_info[0]);
				String station_name = station_info[1];
				int j=0;
				for(TAssignment assignment:assignedlist) {
					if(station_id == assignment.getStation_id()) {
						reassigned[i] = Boolean.TRUE;
						relist[j] = Boolean.TRUE;
						break;
					}
					j++;
				}
				if(!reassigned[i]) {
					TAssignment assignment = new TAssignment(); 
	        		assignment.setStation_id(station_id);
	        		assignment.setNurse_id(Long.valueOf(nurse_id));
	        		assignment.setAddtime(new java.sql.Timestamp(new java.util.Date().getTime()));
	        		assignment.setExpired(new Boolean("False"));
	        		session.save(assignment);
				}
				i++;
			}
			for(i=0;i<relist.length;i++) {
				if(!relist[i]) {
					TAssignment assignment = assignedlist.get(i);
					session.createQuery("update TAssignment set expired=1 where nurse_id="+nurse_id+" and station_id="+assignment.getStation_id()).executeUpdate();
				}
			}
		}
		session.close();
		return new ModelAndView("redirect:nurse_list");
	}
	
	@RequestMapping(value = "/station_add", method = RequestMethod.POST)
	public ModelAndView stationAdd(ModelMap model, @RequestParam String edit_button, @RequestParam String station_id, @RequestParam String name) {
        // 開啟Session，相當於開啟JDBC的Connection
		Session session = HibernateUtil.getSessionFactory().openSession();
		//Transaction表示一組會話操作
		Transaction tx= session.beginTransaction();
		if(edit_button.equals("Add")){
			TStation station = new TStation(); 
			station.setName(name);
			station.setAddtime(new java.sql.Timestamp(new java.util.Date().getTime())); 
			// 將物件映射至資料庫表格中儲存
	        session.save(station);
	        tx.commit(); 
		}
		else {
			session.createQuery("update TStation set name='"+name+"',addtime='"+new java.sql.Timestamp(new java.util.Date().getTime()).toString()+"' where station_id="+station_id).executeUpdate();
		}
		session.close();
		return new ModelAndView("redirect:station_list");
	}
	
	@RequestMapping(value = "/station_del", method = RequestMethod.POST)
	public ModelAndView stationDel(ModelMap model, @RequestParam Long station_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.createQuery("delete TStation where station_id =" + station_id.toString()).executeUpdate();
		session.createQuery("update TAssignment set expired = 1 where station_id =" + station_id.toString()).executeUpdate();
		tx.commit();
		session.close();
		return new ModelAndView("redirect:station_list");
	}
	
	@RequestMapping(value = "/nurse_del", method = RequestMethod.POST)
	public ModelAndView nurseDel(ModelMap model, @RequestParam Long nurse_id) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx= session.beginTransaction();
		session.createQuery("delete TNurse where nurse_id =" + nurse_id.toString()).executeUpdate();
		session.createQuery("update TAssignment set expired = 1 where nurse_id =" + nurse_id.toString()).executeUpdate();
		tx.commit();
		session.close();
		return new ModelAndView("redirect:nurse_list");
	}
}
