package jdbc;

public class InitDatabase {

	static String sql_create_db = "create database `db_englishlearningonline`;";
	static String sql_use_db = "use db_englishlearningonline;";

	static String sql_create_tb_user = "create table tb_user(userid int(20) not null auto_increment primary key,"
			+ "username char(20),usertype int(6),emailaddress char(30),courselist char(255));";

	static String sql_create_tb_course = "create table tb_course(courseid int(20) not null auto_increment primary key,"
			+ "coursename char(30),professorid char(20),professorname char(30),createdtime char(20),materiallist char(255),feedbacklist char(255);";

	static String sql_create_tb_material = "create table tb_material(materialid int(20) not null auto_increment primary key,"
			+ "materialname char(60),filetype char(30),fileurl char(30),uploadedtime char(30);";

	static String sql_create_tb_feedback = "create table tb_feedback(feedbackid int(20) not null auto_increment primary key,"
			+ "userid int(20),usertype int(6),username char(20),comment char(255),createdtime char(30);";

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost/student";
	final static String dbname = "root";
	final static String dbpwd = "root";
	
	private static volatile InitDatabase initdatabase = null;
	private InitDatabase(){};
	
	public static InitDatabase getInitDatabase(){
        if(initdatabase == null){
            synchronized (InitDatabase.class){
                if(initdatabase == null){
                	initdatabase = new InitDatabase();
                }
            }
        }
        return initdatabase;
    } 
	
	public void create_db() {
		java.sql.Connection conn = null;		
		try
		{
			conn = DbUtil.getConnection(JDBC_DRIVER,DB_URL,dbname,dbpwd);
			int ret  = 0 ;
			ret  = DbUtil.executUpdate(conn, sql_create_db, null);
			
			ret  = DbUtil.executUpdate(conn, sql_use_db, null);

			ret  = DbUtil.executUpdate(conn, sql_create_tb_user, null);

			ret  = DbUtil.executUpdate(conn, sql_create_tb_course, null);
			ret  = DbUtil.executUpdate(conn, sql_create_tb_material, null);
			
			ret  = DbUtil.executUpdate(conn, sql_create_tb_feedback, null);
			if (ret !=0) {
				System.out.println("create db error!");
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
}
