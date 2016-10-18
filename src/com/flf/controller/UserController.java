package com.flf.controller;

import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flf.entity.Limit;
import com.flf.entity.User;
import com.flf.service.UserService;

@Controller
@RequestMapping(value="/user")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@RequestMapping(value="/listUserByLmit")
	public @ResponseBody String listUserByLmit(int start,int limit,String callback){
		JSONObject result =new JSONObject();
		try {
			Limit lim = new Limit();
			int index = start>=1?(start-1):0;
			lim.setStart(index*limit);
			lim.setSize(limit);
			List<User> list = userService.listAllUserByLmit(lim);
			JSONArray users = null;
			JSONObject user = null;
			if(list!=null && !list.isEmpty()){
				users = new JSONArray();
				for(User u : list){
					user = JSONObject.fromObject(u);
					users.add(user);
				}
			}
			int num = userService.getCount(null);
			result.put("status", 1);
			result.put("data", users.toString());
			result.put("count", num);
			result.put("msg", "success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return callback+"("+result.toString()+")";
	}
	
	
	@RequestMapping(value="/listUserByCondition")
	public @ResponseBody String listUserByCondition(String account,String name,Integer sex,Integer age,String email,int start,int limit,String callback){
		JSONObject result =new JSONObject();
		try {
			
			User user = new User();
			if(account!=null && !account.equals("")){
				user.setAccount(account);
			}
			
			if(name!=null && !name.equals("")){
				user.setName(name);
			}
			if(email!=null && !email.equals("")){
				user.setEmail(email);
			}
			if(age!=null && age > 0){
				user.setAge(age);
			}
			
			if(sex!=null){
				user.setSex(sex);
			}
			int index = start>=1?(start-1):0;
			user.setStart(index*limit);
			user.setSize(limit);
			
			List<User> list = userService.getUserInfo(user);
			JSONArray users = null;
			JSONObject user1 = null;
			if(list!=null && !list.isEmpty()){
				users = new JSONArray();
				for(User u : list){
					user1 = JSONObject.fromObject(u);
					users.add(user1);
				}
			}
			int num = userService.getCount(null);
			result.put("status", 1);
			result.put("data", users!=null?users.toString():"");
			result.put("count", num);
			result.put("msg", "success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return callback+"("+result.toString()+")";
	}
	

	
	@RequestMapping(value="/getUserById")
	public @ResponseBody String getUserById(@RequestParam int userId,String callback){
		JSONObject result =new JSONObject();
		try {
			User user = userService.getUserById(userId);
			result.put("status", 1);
			result.put("data", JSONObject.fromObject(user).toString());
			result.put("msg", "success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return callback+"("+result.toString()+")";
	}
	
	/**
	 * 保存用户信息
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/addUser")
	public @ResponseBody String addUser(String account,String name,int sex,int age,String email,String callback){
		JSONObject result =new JSONObject();
		try {
			User user = new User();
			user.setAccount(account);
			user.setName(name);
			user.setEmail(email);
			user.setAge(age);
			user.setSex(sex);
			userService.insertUser(user);
			result.put("status", 1);
			result.put("msg", "success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return callback+"("+result.toString()+")";
	}
	
	/**
	 * 请求编辑用户页面
	 * @param userId
	 * @return
	 */
	@RequestMapping(value="/updateUser")
	public @ResponseBody String updateUser(String account,String name,int sex,int age,String email,@RequestParam int userId,String callback){
		JSONObject result =new JSONObject();
		try {
			User user = new User();
			user.setUserId(userId);
			user.setAccount(account);
			user.setName(name);
			user.setEmail(email);
			user.setAge(age);
			user.setSex(sex);
			boolean flag = userService.updateUser(user);
			if(flag){
				result.put("status", 1);
				result.put("msg", "success");
			}else{
				result.put("status", 0);
				result.put("msg", "error");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return callback+"("+result.toString()+")";
	}
	
	/**
	 * 删除某个用户
	 * @param userId
	 * @param out
	 */
	@RequestMapping(value="/deleteUserById")
	public @ResponseBody String deleteUser(@RequestParam int userId,String callback){
		JSONObject result =new JSONObject();
		try {
			userService.deleteUser(userId);
			result.put("status", 1);
			result.put("msg", "success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			result.put("status", 0);
			result.put("msg", e.getMessage());
		}
		return callback+"("+result.toString()+")";
	}
	
		
	public static void main(String[] args) {
		
	}
	
	
}
