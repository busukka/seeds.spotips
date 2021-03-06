package com.seeds.spotips.userclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.seeds.spotips.bean.BoardUpload;
import com.seeds.spotips.dao.BoardDao;
import com.seeds.spotips.dao.PartyDao;

@Component
public class UploadFile {
	//파일 업로드 메소드	
	//String fullPath="D:/Work/.metadata/.plugins/org.eclipse.wst.server.core/tmp0/wtpwebapps/SpringMVC-Board/resources/upload";
	@Autowired
	private BoardDao bDao;
	@Autowired 
	private PartyDao pDao;   //해당클래스에서 dao 주입된게 안쓰이면 에러떨어짐
	
	public boolean fileUp(MultipartHttpServletRequest multi, String b_no){
		System.out.println("fileUp");
		//1.이클립스의 물리적 저장경로 찾기
		String root=multi.getSession().getServletContext().getRealPath("/");
		System.out.println("root="+root);
		String path="resources/upload/";
		System.out.println("path="+path);
		//2.폴더 생성을 꼭 할것...
		File dir=new File(root+path);
		if(!dir.isDirectory()){  //upload폴더 없다면
			dir.mkdirs();  //upload폴더 생성 //mkdir 은 그 전 폴더 하나만 생성 mkdirs 는 하위 모든 폴더 생성
		}
		//3.파일을 가져오기-파일태그 이름들 반환
		
		List<MultipartFile> file=multi.getFiles("bu_files");
		
		//Iterator<String> files=multi.getFileNames(); //파일업로드 2개이상일때
		Map<String,String> fMap=new HashMap<String, String>();
		fMap.put("b_no", b_no);
		fMap.put("path", path);
		boolean f=false;
		
		for(int i=0;i<file.size();i++) {
			String fname=file.get(i).getOriginalFilename();
			System.out.println("file"+i+":"+fname);
			String fileTagName=fname;
			//파일 메모리에 저장
			//MultipartFile mf=multi.getFile(fileTagName); //실제파일
			MultipartFile mf=file.get(i); //실제파일
			//String oriFileName=mf.getOriginalFilename();  //a.txt
			String oriFileName=fileTagName;
			fMap.put("oriFileName", oriFileName);
			
			System.out.println("oriFileName="+oriFileName);
			
			//4.시스템파일이름 생성  a.txt  ==>112323242424.txt
			String sysFileName=System.currentTimeMillis()+"."
					+oriFileName.substring(oriFileName.lastIndexOf(".")+1);
			fMap.put("sysFileName", sysFileName);
			System.out.println("sysFileName="+sysFileName);
			//5.메모리->실제 파일 업로드
			
			try {
				mf.transferTo(new File(root+path+sysFileName));
				f=bDao.fileUpload(fMap);
			}catch (IOException e) {
				e.printStackTrace();
			}
		} //for end
		
		if(f)
			return true;
		return false;
	}
	
	//파일 다운로드
		public void download(String fullPath, 
				String oriFileName, HttpServletResponse resp) throws Exception {
			
			//한글파일 깨짐 방지
			String downFile = URLEncoder.encode(oriFileName, "UTF-8");
			//파일 객체 생성
			File file = new File(fullPath);
			//다운로드 경로 파일을 읽어 들임
			InputStream is = new FileInputStream(file);
			//반환객체설정
			resp.setContentType("application/octet-stream");
			resp.setHeader("content-Disposition", 
					"attachment; filename=\""+downFile+"\"");
			//반환객체에 스트림 연결
			OutputStream os = resp.getOutputStream();
			
			//파일쓰기
			byte[] buffer = new byte[1024];
			int length;
			while((length = is.read(buffer)) != -1){
				os.write(buffer,0,length);
			}
			os.flush();
			os.close();
			is.close();
		}

		public boolean fileUp(List<MultipartFile> files, String p_no, MultipartHttpServletRequest multi) {
			String filePath = "E:\\spotipsUpload\\partyUpload\\";
			System.out.println("fileUp");
			//1.이클립스의 물리적 저장경로 찾기
			String root=multi.getSession().getServletContext().getRealPath("/");
			System.out.println("root="+root);
			String path="resources/upload/party/";
			System.out.println("path="+path);
			
			//2.폴더 생성을 꼭 할것...
			File dir=new File(path);
			if(!dir.isDirectory()){  //upload폴더 없다면
				dir.mkdirs();  //upload폴더 생성 //mkdir 은 그 전 폴더 하나만 생성 mkdirs 는 하위 모든 폴더 생성
			}
			
			//3.파일을 가져오기-일태그 이름들 반환
			ArrayList<BoardUpload> buList = new ArrayList<BoardUpload>();
			HashMap<String, Object> fMap= new HashMap<String, Object>();
			
			
			for(int i =0;i<files.size();i++) {
				BoardUpload bu = new BoardUpload();
				bu.setBu_code(p_no);
				bu.setBu_path(path);
				
				String oriFileName = files.get(i).getOriginalFilename();
				bu.setBu_fileori(oriFileName);
				
				//4.시스템파일이름 생성  a.txt  ==>112323242424(밀리세컨드).txt
				String sysFileName = System.currentTimeMillis()+"." 
							+oriFileName.substring(oriFileName.lastIndexOf(".")+1); //==>.txt
				bu.setBu_filesys(sysFileName);
				buList.add(bu);	
				System.out.println("분류번호:"+bu.getBu_code());
				System.out.println("시스파일:"+bu.getBu_filesys());
				System.out.println("오리파일:"+bu.getBu_fileori());
				System.out.println("경로:"+bu.getBu_path());
				
				try {
					files.get(i).transferTo(new File(root+path+sysFileName));
					System.out.println("파일업로드 완료");
			
				} catch (IOException e) {
					System.out.println("파일업로드 실패");
					e.printStackTrace();
				}
			}
			
			//fMap.put("fileList", buList);
			
			
			return pDao.insertFileUpload(buList);
		}
	
	
	
}

