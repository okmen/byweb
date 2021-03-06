package cn.web.action.user;


import javax.servlet.http.HttpServletRequest;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//import com.baiyue.services.IBannerService;
import com.baiyue.services.cts.user.ICtsUserService;
import com.baiyue.vo.result.LoginSuccessCtsUserInfo;
import com.baiyue.web.BaseWebAction;
import com.utils_max.JsonUtil;
//import com.utils_max.ParseUtils;
import com.utils_max.ResultMsg;
import com.utils_max.encrypt.MD5Encrypt;
import com.utils_max.enums.ResultStatusEnums;
import com.utils_max.redis.RedisUtil;

/*
 * 前端用户登陆模块
 */
@Controller
@RequestMapping(value = "/sso/")
public class LoginMgtController  extends BaseWebAction{

	
	/**
	 * 用户模块 service api 服务
//	 */
//	@Autowired
//	private IBannerService bannerService;
	@Autowired
	private ICtsUserService ctsUserService;
	
	@ResponseBody
	@RequestMapping(value = "login")
	public String login(String username,String pwd) throws Exception {
		ResultMsg result=null;
		if(ctsUserService!=null){
			 result=ctsUserService.login(username, pwd);
		}else{
			result=new ResultMsg();
			result.setStatus(ResultStatusEnums.error);
			result.setMsg("LoginMgtController:ctsUserService为null!"); 
		}
		return  JsonUtil.objectToJsonStr(result);
	}
	
	@ResponseBody
	@RequestMapping(value = "getUserInfo")
	public String getUser(HttpServletRequest request) throws Exception {
		ResultMsg result=new ResultMsg();
		LoginSuccessCtsUserInfo user= super.getLoginSuccessCtsUserInfo(request);
		if(user!=null){
			result.setStatus(ResultStatusEnums.success);
			result.setData(user);
		}else{
			result.setStatus(ResultStatusEnums.login_expired);
			result.setMsg("登录过期"); 
		}
		return  JsonUtil.objectToJsonStr(result);
	}
}
