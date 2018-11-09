package com.seeds.spotips;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.seeds.spotips.bean.Reply;
import com.seeds.spotips.service.BoardManagement;

@Controller
@RequestMapping(value = "/ajax")
public class BoardAjaxController {
	@Autowired
	private BoardManagement bm;
	
	ModelAndView mav;                           //대글 추가시 한글깨짐 방지
	/*@RequestMapping(value = "/replyInsert", produces = "application/json; charset=utf8")
	//json을 커맨드 객체에 저장하기 위해서는  @RequestBody를 사용해야 됨.
	public @ResponseBody String replyInsert(@RequestBody Reply r) {
		System.out.println("r_bnum="+r.getR_bnum()); //원글번호
		System.out.println("r_contents="+r.getR_contents()); //원글번호
		String json=bm.replyInsert(r);
		return json;
		//서블릿에서 사용하던 방식을 @ResponseBody가 대신함
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print(json);
	}*/
	
	@RequestMapping(value = "/postUpload" , produces = "application/json; charset=utf8")
	public  ModelAndView postUpload(MultipartHttpServletRequest multi) {
		mav=bm.postUpload(multi);
		return mav;
	};
	/*@RequestMapping(value = "/postInfo")
	public  ModelAndView postInfo(String b_no) {
		mav=bm.postInfo(b_no);
		return mav;
	};*/
	
	@RequestMapping(value = "/replyInsert", produces = "application/json; charset=utf8")
	public ModelAndView  replyInsert(Reply r) {
		mav=bm.replyInsert(r); 
		return mav; //jackson Map-->json 변환해줌
		//{'rList', rList}---->{"rList":[],[],[]...}
	}
	
	
	
}
