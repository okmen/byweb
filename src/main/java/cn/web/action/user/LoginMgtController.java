package cn.web.action.user;


import java.util.Date;

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
				info=new Banner();
				info.setAdName("test001"+id);
				info.setCreateTime(new Date());
				info.setUpdateTime(new Date());
				info.setUpdateUserId(12);
				info.setPublishTime(new Date());
				info.setStatus(1);
				info.setUrl("http://baidu.com");
				info.setNum(2);
				info.setIsDelete(0); 
				info.setImgUrl("http://baidu.com");
				info.setAdName("ceshi312");
				info.setSliderTime(3213);
				info.setCreateUserId(1321);
				int ref=bannerService.insert(info);
				System.out.println("error!insert result:"+ref); 
			}
		}else{
			System.out.println(31);
		}
		
		System.out.println(id);
		return  id;
	}
}
