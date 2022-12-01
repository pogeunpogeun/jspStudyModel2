package _test.exam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tika.Tika;
import org.json.simple.JSONObject;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import _common.Util;

@WebServlet("/exam_servlet/*") // url-mapping
public class ExamController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doProc(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Util util = new Util();
		String path = request.getContextPath();
		String url = request.getRequestURL().toString();
		String uri = request.getRequestURI().toString();

		/*
		 * System.out.println("path : " + path); System.out.println("url : " + url);
		 * System.out.println("uri : " + uri);
		 */

		String[] imsiUriArray = uri.split("/");
		String imsiUriFileName = imsiUriArray[imsiUriArray.length - 1];
		
		request.setAttribute("path", path);

		String forwardPage = "/WEB-INF/_test/exam";

		if (imsiUriFileName.equals("01.do")) {
			forwardPage += "/01.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("01Proc.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			int age = Integer.parseInt(age_);

			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("age", age);

			forwardPage += "/01Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);

		} else if (imsiUriFileName.equals("02.do")) {
			forwardPage += "/02.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("02Proc.do")) {
			String name = request.getParameter("name");
			String year_ = request.getParameter("year");
			int year = Integer.parseInt(year_);

			int age = (2022 - year) + 1;

			request.setAttribute("name", name);
			request.setAttribute("year", year);
			request.setAttribute("age", age);

			forwardPage += "/02Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);

		} else if (imsiUriFileName.equals("03.do")) {
			forwardPage += "/03.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("03Proc.do")) {
			String name = request.getParameter("name");
			String idNum = request.getParameter("idNum");
			String address = request.getParameter("address");

			String gender = "";
			if (idNum.substring(7, 8).equals("1") || idNum.substring(7, 8).equals("3")) {
				gender = "남성";
			} else if (idNum.substring(7, 8).equals("2") || idNum.substring(7, 8).equals("4")) {
				gender = "여성";
			}
			String year_ = idNum.substring(0, 2);
			String year2_ = idNum.substring(0, 2);

			int year = 1900 + Integer.parseInt(year_);
			int year2 = 2000 + Integer.parseInt(year2_);

			int age = 0;
			if (idNum.substring(0, 1).equals("9")) {
				age = 2022 - year;
			} else if (idNum.substring(0, 1).equals("0")) {
				age = 2022 - year2;
			}

			request.setAttribute("name", name);
			request.setAttribute("idNum", idNum);
			request.setAttribute("address", address);
			request.setAttribute("gender", gender);
			request.setAttribute("age", age);

			forwardPage += "/03Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);

		} else if (imsiUriFileName.equals("04.do")) {
			forwardPage += "/04.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("04Proc.do")) {
			String formCounter_ = request.getParameter("formCounter");
			int formCounter = Integer.parseInt(formCounter_);

			ArrayList<String> list = new ArrayList<>();

			for (int i = 1; i <= formCounter; i++) {
				String name = request.getParameter("name_" + i);
				String address = request.getParameter("address_" + i);
				String age_ = request.getParameter("age_" + i);
				int age = Integer.parseInt(age_);

				String msg = name + "|" + address + "|" + age;
				list.add(msg);
			}
			request.setAttribute("list", list);
			forwardPage += "/04Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);

		} else if (imsiUriFileName.equals("05.do")) {
			forwardPage += "/05.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("05Proc.do")) {
			String[] names = request.getParameterValues("name");
			String name = "";
			for (int i = 0; i < names.length; i++) {
				name += "," + names[i];
			}
			name = name.substring(1);
			String gender = request.getParameter("gender");
			String aboutAge = request.getParameter("aboutAge");

			String[] hobbys = request.getParameterValues("hobby");
			String hobby = "";
			for (int i = 0; i < hobbys.length; i++) {
				hobby += "," + hobbys[i];
			}
			hobby = hobby.substring(1);

			String age_ = request.getParameter("age");
			int age = Integer.parseInt(age_);

			String memo = request.getParameter("memo");
			memo = memo.replace("\n", "<br>");

			String birthday = request.getParameter("birthday");

			HashMap<String, String> map = new HashMap<>();
			map.put("name", name);
			map.put("gender", gender);
			map.put("aboutAge", aboutAge);
			map.put("hobby", hobby);
			map.put("age", age + "");
			map.put("memo", memo);
			map.put("birthday", birthday);

			request.setAttribute("map", map);
			forwardPage += "/05Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("06.do")) {
			forwardPage += "/06.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("06Proc.do")) {
			String testDbId = "hong";
			String testDbPw = "1234";
			
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			String result = "";
			
			if(id.equals(testDbId) && passwd.equals(testDbPw)) {
				result = "로그인성공";
			} else {
				result = "로그인실패";
			}
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			
			
			forwardPage += "/06Result1.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage); rd.forward(request, response);
			//response.sendRedirect("/jspStudyModel2/exam_servlet/06Proc2.do?id=" + id + "&result=" + result);
			
		} else if (imsiUriFileName.equals("06Proc2.do")) {
			String id = request.getParameter("id");
			String result = request.getParameter("result");
			
			request.setAttribute("id", id);
			request.setAttribute("result", result);
			
			forwardPage += "/06Result2.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("07.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			
			if(name == null || name.trim().equals("")) { name = ""; }
			if(address == null ||address.trim().equals("")) { address = ""; }
			if(age_ == null || age_.trim().equals("")) { age_ = ""; }
			
			//int age = Integer.parseInt(age_);
			
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("age", age_);
			
			forwardPage += "/07.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
			
		} else if (imsiUriFileName.equals("07Proc.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			int age = Integer.parseInt(age_);
			
			request.setAttribute("name", name);
			request.setAttribute("address", address);
			request.setAttribute("age", age);
			
			forwardPage += "/07Result.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("08.do")) {
			forwardPage += "/08.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
			rd.forward(request, response);
		} else if (imsiUriFileName.equals("08Proc.do")) {
			String name = request.getParameter("name");
			String address = request.getParameter("address");
			String age_ = request.getParameter("age");
			String test = request.getParameter("test");
			String num1_ = request.getParameter("num1");
			String num2_ = request.getParameter("num2");
			String result_ = request.getParameter("result");
			
			int age = Integer.parseInt(age_);
			int num1 = Integer.parseInt(num1_);
			int num2 = Integer.parseInt(num2_);
			int result = Integer.parseInt(result_);
			
			int imsiResult = num1 +  num2;
			if(result - imsiResult != 0) {
				//response.sendRedirect(path + "/exam_servlet/08.do");
				
				/*
				 * response.setContentType("text/html; charset=utf-8");
				 * PrintWriter out =  response.getWriter(); 
				 * out.println("<script>");
				 * out.println("alert('결과 다름');"); 
				 * out.println("location.href = '" + path + "/exam_servlet/08.do';");
				 * out.println("</script>");
				 * out.flush();
				 * out.close();
				 */
				
				request.setAttribute("errorCode", "err001");
				request.setAttribute("errorMsg", "결과가 다름");
				
				forwardPage += "/error.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);				
				return;
			}
				HashMap<String, String> map = new HashMap<>();
				map.put("name", name);
				map.put("address", address);
				map.put("age", age+"");
				map.put("test", test);
				map.put("num1", num1+"");
				map.put("num2", num2+"");
				map.put("result", result+"");
				request.setAttribute("map", map);
				
				forwardPage += "/08Result.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);
			} else if (imsiUriFileName.equals("09.do")) {
				forwardPage += "/09.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);
			} else if (imsiUriFileName.equals("09Proc.do")) {
				String name = request.getParameter("name");
				String kor_ = request.getParameter("kor");
				String eng_ = request.getParameter("eng");
				String mat_ = request.getParameter("mat");
				
				int kor = Integer.parseInt(kor_);
				int eng = Integer.parseInt(eng_);
				int mat = Integer.parseInt(mat_);
				
				int tot = kor + eng + mat;
				double avg = tot / 3.0;
				
				String queryString = "";
				queryString = "?name=" + name;
				queryString = "?kor=" + kor;
				queryString = "?eng=" + eng;
				queryString = "?mat=" + mat;
				queryString = "?tot=" + tot;
				queryString = "?avg=" + avg;
				
				String imsiPage = path + "/exam_servlet/09Result.do" + queryString;
				response.sendRedirect(imsiPage);				
			} else if (imsiUriFileName.equals("09Result.do")) {
				String name = request.getParameter("name");
				String kor_ = request.getParameter("kor");
				String eng_ = request.getParameter("eng");
				String mat_ = request.getParameter("mat");
				
				int kor = Integer.parseInt(kor_);
				int eng = Integer.parseInt(eng_);
				int mat = Integer.parseInt(mat_);
				int tot = kor + eng + mat;
				double avg = tot / 3;
				
				HashMap<String, String> map = new HashMap<>();
				map.put("name", name);
				map.put("kor", kor+"");
				map.put("eng", eng+"");
				map.put("mat", mat+"");
				map.put("tot", tot+"");
				map.put("avg", avg+"");
				
				request.setAttribute("map", map);
				
				forwardPage += "/09Result.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);				
			} else if (imsiUriFileName.equals("json1.do")) {			
				forwardPage += "/json1.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);		
			} else if (imsiUriFileName.equals("join1Proc.do")) {
				String id = request.getParameter("id");
				String passwd = request.getParameter("passwd");
				String name = request.getParameter("name");
				String age_ = request.getParameter("age");
				
				int age = Integer.parseInt(age_);
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("id", id);
				jsonObject.put("passwd", passwd);
				jsonObject.put("name", name);
				jsonObject.put("age", age);
				
				String jsonMember = jsonObject.toString();
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println(jsonMember);
				out.flush();
				out.close();
			} else if (imsiUriFileName.equals("json2.do")) {
				forwardPage += "/json2.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);	
			} else if (imsiUriFileName.equals("join2Proc.do")) {
				String name = request.getParameter("name");
				String kor_ = request.getParameter("kor");
				String eng_ = request.getParameter("eng");
				String mat_ = request.getParameter("mat");
				String sci_ = request.getParameter("sci");
				String his_ = request.getParameter("his");
				
				int kor = Integer.parseInt(kor_);
				int eng = Integer.parseInt(eng_);
				int mat = Integer.parseInt(mat_);
				int sci = Integer.parseInt(sci_);
				int his = Integer.parseInt(his_);
				
				int tot = kor + eng + mat + sci + his;
				double avg = tot / 5.0;
				
				JSONObject jsonObject = new JSONObject();
				jsonObject.put("name", name);
				jsonObject.put("kor", kor);
				jsonObject.put("eng", eng);
				jsonObject.put("mat", mat);
				jsonObject.put("sci", sci);
				jsonObject.put("his", his);
				jsonObject.put("tot", tot);
				jsonObject.put("avg", avg);
				
				String jsonSungjuk = jsonObject.toString();
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter();
				out.println(jsonSungjuk);
				out.flush();
				out.close();		
			} else if (imsiUriFileName.equals("attach1.do")) {
				forwardPage += "/attach1.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);
			} else if (imsiUriFileName.equals("attach1Proc.do")) {
				String attachPath = _common.Constants.ATTACH_PATH;
				int maxUpload = _common.Constants.MAX_UPLOAD;				
				String uploadPath = attachPath + path + "/test";
				
				MultipartRequest multi = new MultipartRequest(
						request,
						uploadPath,
						maxUpload,
						"utf-8",
						new DefaultFileRenamePolicy()
						);
				
				String memo = multi.getParameter("memo");
				
				String originalName = "-";
				String saveName = "-";
				long fileSize = 0;
				String fileType = "-";
				String mimeType = "-";
				
				java.io.File file_1 = multi.getFile("file_1");
				if(file_1 != null) { // 첨부파일이 있으면
					originalName = multi.getOriginalFileName("file_1");
					saveName = multi.getFilesystemName("file_1");
					fileSize = file_1.length();
					fileType = multi.getContentType("file_1");
					
					Tika tika = new Tika();				
					mimeType = tika.detect(file_1);
					
					String extName = saveName.substring(saveName.lastIndexOf(".") + 1);
					String newSaveName = util.getDateTime() + "_" + util.createUuid() + "." + extName;
					
					java.io.File newFile = new java.io.File(uploadPath + "/" + newSaveName); 
					file_1.renameTo(newFile); // 파일 이름 변경 후 이동
					saveName = newSaveName;
					
					if(!fileType.equals(mimeType)) {
						java.io.File f1 = new java.io.File(uploadPath + "/" + saveName);
						if(f1.exists()) {
							f1.delete();
						}
						originalName = "-";
						saveName = "-";
						fileSize = 0;
						fileType = "-";
						mimeType = "-";
					}  
				} 
				String attachInfo = "";
				attachInfo += originalName + "|";
				attachInfo += saveName + "|";
				attachInfo += fileSize + "|";
				attachInfo += fileType + "|";
				attachInfo += mimeType;
				
				response.sendRedirect(path + "/exam_servlet/attach1.do");
			} else if (imsiUriFileName.equals("attachWhile.do")) {
				forwardPage += "/attachWhile.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);
			} else if (imsiUriFileName.equals("attachWhileProc.do")) {
				String attachPath = _common.Constants.ATTACH_PATH;
				int maxUpload = _common.Constants.MAX_UPLOAD;				
				String uploadPath = attachPath + path + "/test";
				
				MultipartRequest multi = new MultipartRequest(
						request,
						uploadPath,
						maxUpload,
						"utf-8",
						new DefaultFileRenamePolicy()
						);
				String memo = multi.getParameter("memo");
				String attachCounter_ = multi.getParameter("attachCounter");
				int attachCounter = Integer.parseInt(attachCounter_);
				String[] array = new String[attachCounter];
				Enumeration files = multi.getFileNames(); // 첨부파일의 집합
				while(files.hasMoreElements()) { // 다음 요소가 있으면
					String originalName = "-";
					String saveName = "-";
					long fileSize = 0;
					String fileType = "-";
					String mimeType = "-";
					
					String tagName = (String) files.nextElement(); // 첨부파일 박스 이름
					java.io.File f1 = multi.getFile(tagName);
					if(f1 != null) {
						originalName = multi.getOriginalFileName(tagName);
						saveName = multi.getFilesystemName(tagName);
						fileSize = f1.length();
						fileType = multi.getContentType(tagName);
						
						Tika tika = new Tika();				
						mimeType = tika.detect(f1);
						
						String extName = saveName.substring(saveName.lastIndexOf(".") + 1);
						String newSaveName = util.getDateTime() + "_" + util.createUuid() + "." + extName;
						
						java.io.File newFile = new java.io.File(uploadPath + "/" + newSaveName); 
						f1.renameTo(newFile); // 파일 이름 변경 후 이동
						saveName = newSaveName;
						
						if(!fileType.equals(mimeType)) {
							java.io.File f2 = new java.io.File(uploadPath + "/" + saveName);
							if(f2.exists()) {
								f2.delete();
							}
							originalName = "-";
							saveName = "-";
							fileSize = 0;
							fileType = "-";
							mimeType = "-";
						}  
					}
					String attachInfo = "";
					attachInfo += originalName + "|";
					attachInfo += saveName + "|";
					attachInfo += fileSize + "|";
					attachInfo += fileType + "|";
					attachInfo += mimeType;
					
					String imsiTagName = tagName.replace("file_", "");
					int idx = Integer.parseInt(imsiTagName);
					array[idx] = attachInfo;
				}
				String dispInfo = "";
				for(int i = 0; i < array.length; i++) {
					dispInfo += "," + array[i];
					System.out.println("dispInfo[" + i + "] : " + array[i]);
				}
				dispInfo = dispInfo.substring(1);
				System.out.println("dispInfo : " + dispInfo);
				response.sendRedirect(path + "/exam_servlet/attachWhile.do");
			} else if (imsiUriFileName.equals("attachFor.do")) {
				forwardPage += "/attachFor.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(forwardPage);
				rd.forward(request, response);
			} else if (imsiUriFileName.equals("attachForProc.do")) {
				String attachPath = _common.Constants.ATTACH_PATH;
				int maxUpload = _common.Constants.MAX_UPLOAD;				
				String uploadPath = attachPath + path + "/test";
				
				MultipartRequest multi = new MultipartRequest(
						request,
						uploadPath,
						maxUpload,
						"utf-8",
						new DefaultFileRenamePolicy()
						);
				String memo = multi.getParameter("memo");
				String attachCounter_ = multi.getParameter("attachCounter");
				int attachCounter = Integer.parseInt(attachCounter_);
				String[] array = new String[attachCounter];
				
				for(int i = 0; i < attachCounter; i++) {				
					String originalName = "-";
					String saveName = "-";
					long fileSize = 0;
					String fileType = "-";
					String mimeType = "-";
					
					String tagName = "file_" + i; // 첨부파일 박스 이름
					java.io.File f1 = multi.getFile(tagName);
					if(f1 != null) {
						originalName = multi.getOriginalFileName(tagName);
						saveName = multi.getFilesystemName(tagName);
						fileSize = f1.length();
						fileType = multi.getContentType(tagName);
						
						Tika tika = new Tika();				
						mimeType = tika.detect(f1);
						
						String extName = saveName.substring(saveName.lastIndexOf(".") + 1);
						String newSaveName = util.getDateTime() + "_" + util.createUuid() + "." + extName;
						
						java.io.File newFile = new java.io.File(uploadPath + "/" + newSaveName); 
						f1.renameTo(newFile); // 파일 이름 변경 후 이동
						saveName = newSaveName;
						
						if(!fileType.equals(mimeType)) {
							java.io.File f2 = new java.io.File(uploadPath + "/" + saveName);
							if(f2.exists()) {
								f2.delete();
							}
							originalName = "-";
							saveName = "-";
							fileSize = 0;
							fileType = "-";
							mimeType = "-";
						}  
					}
					String attachInfo = "";
					attachInfo += originalName + "|";
					attachInfo += saveName + "|";
					attachInfo += fileSize + "|";
					attachInfo += fileType + "|";
					attachInfo += mimeType;
					
					String imsiTagName_ = tagName.replace("file_", "");
					int idx = Integer.parseInt(imsiTagName_);
					array[idx] = attachInfo;
				}
				String dispInfo = "";
				for(int i = 0; i < array.length; i++) {
					dispInfo += "," + array[i];
					System.out.println("dispInfo[" + i + "] : " + array[i]);
				}
				dispInfo = dispInfo.substring(1);
				System.out.println("dispInfo : " + dispInfo);
				response.sendRedirect(path + "/exam_servlet/attachFor.do");
		} else {
			System.out.println("no");
		}
	}
}
