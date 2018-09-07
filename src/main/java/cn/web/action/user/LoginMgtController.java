package cn.web.action.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.dubbo.config.annotation.Reference;
import com.baiyue.entity.Banner;
import com.baiyue.services.IBannerService;
import com.utils_max.ParseUtils;

/*
 * 前端用户登陆模块
 */
@Controller
@RequestMapping(value = "/sso/")
public class LoginMgtController {

	
	/**
	 * 用户模块 service api 服务
//	 */
	@Autowired
	private IBannerService bannerService;
	
	
	@ResponseBody
	@RequestMapping(value = "login")
	public String download(String id,String pwd) throws Exception {
		if(bannerService!=null){
			Banner info=bannerService.selectByPrimaryKey(ParseUtils.parseInt(id));
			if(info!=null){
				System.out.println("ok");
			}else{
				System.out.println("error!"); 
			}
		}else{
			System.out.println(31);
		}
		
		System.out.println(id);
		return  id;
	}
}
