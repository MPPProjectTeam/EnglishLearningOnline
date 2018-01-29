package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.FeedbakDao;
import daos.MaterialDao;
import daos.ProfessorDao;
import daos.StudentDao;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class HomeProfessor
 */
@WebServlet("/HomeProfessor")
public class HomeProfessor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	// location to store file uploaded
	private static final String UPLOAD_DIRECTORY = "upload";
	// upload settings
	private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
	private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
	private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeProfessor() {
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


		if(formType.equals("CreateCourse"))
		{
			String courseName = request.getParameter("courseName");
			String preCourseId = request.getParameter("preCourseId");
			int userId = ProfessorDao.getStudentIdByName(userName);
			//StudentDao.enrollCourse(""+userId, courseID);	
			ProfessorDao.createCourse(courseName, ""+userId, userName, preCourseId);
		}
		else if(formType.equals("Feedback")) {
			String courseID = request.getParameter("CourseIDFeed");
			String comment = request.getParameter("comment");
			String replyID = request.getParameter("ReplyId");
			int userId = StudentDao.getStudentIdByName(userName);
			FeedbakDao.ReplyFeedbackByProfessor(""+userId, userName, courseID,comment, replyID);
		}else if(formType.equals("UploadMaterials")) {
			System.out.println("post---UploadMaterials");
			//1.store the file firsts
			uploadfile(request,response);
		}
		
		RequestDispatcher RequetsDispatcherObj =request.getRequestDispatcher("/homeProfessor.jsp");
		RequetsDispatcherObj.forward(request, response);
	}
	public void storefileur(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException{
		String materialname = request.getParameter("materialname");
		String filetype = request.getParameter("filetype");
		String fileurl = request.getParameter("fileurl");
		String courseid = request.getParameter("courseid");
		String professorid = request.getParameter("professorid");
		MaterialDao.UploadMaterialForCourse(materialname, filetype, fileurl, courseid, professorid);
	}
	public void uploadfile(HttpServletRequest request,
            HttpServletResponse response) throws IOException, ServletException{

	        // checks if the request actually contains upload file
	        if (!ServletFileUpload.isMultipartContent(request)) {
	            // if not, we stop here
	            PrintWriter writer = response.getWriter();
	            writer.println("Error: Form must has enctype=multipart/form-data.");
	            writer.flush();
	            return;
	        }
	 
	        // configures upload settings
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        // sets memory threshold - beyond which files are stored in disk
	        factory.setSizeThreshold(MEMORY_THRESHOLD);
	        // sets temporary location to store files
	        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
	 
	        ServletFileUpload upload = new ServletFileUpload(factory);
	         
	        // sets maximum size of upload file
	        upload.setFileSizeMax(MAX_FILE_SIZE);
	         
	        // sets maximum size of request (include file + form data)
	        upload.setSizeMax(MAX_REQUEST_SIZE);
	 
	        // constructs the directory path to store upload file
	        // this path is relative to application's directory
	        String uploadPath = getServletContext().getRealPath("")
	                + UPLOAD_DIRECTORY;
	        System.out.println(getServletContext().getRealPath(""));
	        System.out.println(File.separator);
	         System.out.println("uploadPath:"+uploadPath);
	         
	         
	        // creates the directory if it does not exist
	        File uploadDir = new File(uploadPath);
	        if (!uploadDir.exists()) {
	            uploadDir.mkdir();
	        }
	 
	        try {
	            // parses the request's content to extract file data
	            @SuppressWarnings("unchecked")
	            List<FileItem> formItems = upload.parseRequest(request);
	 
	            if (formItems != null && formItems.size() > 0) {
	                // iterates over form's fields
	                for (FileItem item : formItems) {
	                    // processes only fields that are not form fields
	                    if (!item.isFormField()) {
	                        String fileName = new File(item.getName()).getName();
	                        String filePath = uploadPath + File.separator + fileName;
	                        
	                        System.out.println("filePath:" + filePath);
	                        File storeFile = new File(filePath);
	 
	                        // saves the file on disk
	                        item.write(storeFile);
	                        
	                        request.setAttribute("message",
	                            "Upload has been done successfully!");
	                		   //2.intert the record to the tb_material
	                        storefileur(request,response);
	                    }
	                }
	            }
	        } catch (Exception ex) {
	            request.setAttribute("message",
	                    "There was an error: " + ex.getMessage());
	        }
	       /* // redirects client to message page
	        getServletContext().getRequestDispatcher("/message.jsp").forward(
	                request, response);*/
	    }
}
