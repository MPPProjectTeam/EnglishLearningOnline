package jdbc;

public class InitDatabase {

	static String sql_create_db = "drop database IF EXISTS db_englishlearningonline; " + 
			" create database db_englishlearningonline;";
	static String sql_use_db = "use db_englishlearningonline;";

	static String sql_create_tb_user = "create table tb_user(userid int(20) not null auto_increment primary key,"
			+ "username char(20),usertype int(6),emailaddress char(30),createddate datetime DEFAULT CURRENT_TIMESTAMP);";

	static String sql_create_tb_course = "create table tb_course(courseid int(20) not null auto_increment primary key,"
			+ "coursename char(30),professorid char(20),professorname char(30),createdtime datetime DEFAULT CURRENT_TIMESTAMP;";
	
	static String sql_create_tb_section = "create table tb_section(sectionid int(20) not null auto_increment primary key,"
			+ "userid int(20),courseid int(20),createdtime datetime DEFAULT CURRENT_TIMESTAMP;";
	
	static String sql_create_tb_material = "create table tb_material(materialid int(20) not null auto_increment primary key,"
			+ " courseid int(20), materialname char(60),filetype char(30),fileurl char(30),uploadedtime datetime DEFAULT CURRENT_TIMESTAMP;";

	static String sql_create_tb_feedback = "create table tb_feedback(feedbackid int(20) not null auto_increment primary key,"
			+ "userid int(20),usertype int(6),username char(20),comment char(255),courseid int(20), createdtime datetime DEFAULT CURRENT_TIMESTAMP;";

	final static String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	final static String DB_URL = "jdbc:mysql://localhost:3306/db_englishlearningonline";
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
			conn = DbUtil.getConnectionJama();
			int ret  = 0 ;
			ret  = DbUtil.executUpdate(sql_create_db, null);
			ret  = DbUtil.executUpdate(sql_use_db, null);
			ret  = DbUtil.executUpdate(sql_create_tb_user, null);
			ret  = DbUtil.executUpdate(sql_create_tb_course, null);
			ret  = DbUtil.executUpdate(sql_create_tb_section, null);
			ret  = DbUtil.executUpdate(sql_create_tb_material, null);
			ret  = DbUtil.executUpdate(sql_create_tb_feedback, null);
			if (ret !=0) {
				System.out.println("create db error!");
			}
		}catch (Exception e) {
            e.printStackTrace();
        }
	}
}
