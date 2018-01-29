package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.FeedbakDao;
import daos.StudentDao;

import java.io.File;  
import java.io.FileInputStream;  
import java.io.OutputStream;  
import java.net.URLEncoder;  

/**
 * Servlet implementation class HomeStudent
 */
@WebServlet("/HomeStudent")
public class HomeStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "upload";
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String formType = request.getParameter("formType");
		String userName = request.getParameter("userName");
		if(formType.equals("Enroll"))
		{
			String courseID = request.getParameter("courseId");
			int userId = StudentDao.getStudentIdByName(userName);
			StudentDao.enrollCourse(""+userId, courseID);	
		}
		else if(formType.equals("Feedback")) {
			String courseID = request.getParameter("CourseIDFeed");
			String comment = request.getParameter("comment");
			int userId = StudentDao.getStudentIdByName(userName);
			FeedbakDao.AddFeedbackByStudent(""+userId, userName, courseID,comment);
		}else if(formType.equals("DownloadMaterials")) {
			String courseID = request.getParameter("CourseIDFeed");
			String comment = request.getParameter("comment");
			int userId = StudentDao.getStudentIdByName(userName);
			
			downloadfile(request,response);
			
//			FeedbakDao.AddFeedbackByStudent(""+userId, userName, courseID,comment);
		}
		
		
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeStudent.jsp");
		RequetsDispatcherObj.forward(request, response);
	}

	public void downloadfile(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException{
		
        String fileName = request.getParameter("materialname");  
        fileName = new String(fileName.getBytes("iso8859-1"), "UTF-8");  
        String fileSaveRootPath = this.getServletContext().getRealPath("")
                + UPLOAD_DIRECTORY;  
        System.out.println("file download path:" + fileSaveRootPath);
        String filePath = findFileSavePathByFileName(fileName, fileSaveRootPath);  

        // 根据路径创建文件  
        File file = new File(filePath);  
  
        if (!file.exists()) {  
        		System.out.println("the file you want is not exist");
        		return;  
        } 
        
        // 创建输入流对象  
        FileInputStream fis = new FileInputStream(file);  
          
        // 设置下载的类型 告诉浏览器 需要以下载的方式操作  
        response.setContentType("application/x-msdownload");  
        // 下载头设置  
        response.setHeader("content-disposition", "attachment;fileName="  
                + java.net.URLEncoder.encode(fileName, "UTF-8"));  
  
        // 写出的流  
        OutputStream os = response.getOutputStream();  
  
        byte[] buffer = new byte[1024];  
        int len = 0;  
        while ((len = fis.read(buffer)) != -1) {  
            os.write(buffer, 0, len);  
        }  
        os.close();  
        fis.close();   
	}
	
    public String findFileSavePathByFileName(String filename, String saveRootPath) {  
        int hashcode = filename.hashCode();  
        int dir1 = hashcode & 0xf; // 0--15  
        int dir2 = (hashcode & 0xf0) >> 4; // 0-15  
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2; // upload\2\3 upload\3\5  
        File file = new File(dir);  
        if (!file.exists()) {    
            file.mkdirs();  
        }  
        return dir;  
    } 
	
}
