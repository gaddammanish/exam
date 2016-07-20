import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
public class HelloWorld extends HttpServlet {
 int mainflag,score;
 String quest,op1,op2;
 ServletContext context;
  public void init() throws ServletException
  {
    score=0;
   mainflag=1;
  }

  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
            throws ServletException, IOException
  {
      if(mainflag>1){
        String answered=request.getParameter("gender");
        String ans=question.retrive(mainflag-1,4);
        if(answered.equals(ans)){
          score++;
        }
      }
      boolean exist=question.eventPics(mainflag);
      if(!exist){
        mainflag=0;
      }
      else{
        question ob=new question();
        quest=ob.retrive(mainflag,1);
        op1=ob.retrive(mainflag,2);
        op2=ob.retrive(mainflag,3);
      
        request.setAttribute("quest",quest);
        request.setAttribute("op1",op1);
        request.setAttribute("op2",op2);
        request.setAttribute("test","hiii");
      }

      response.setContentType("text/html");
      PrintWriter out = response.getWriter();
      if(mainflag!=0)
      {
        RequestDispatcher rd=request.getRequestDispatcher("finaltimer.jsp");
        rd.forward(request,response);
        mainflag++;
      }
      else
      {
          out.println("successfully answered all questions ...your score="+score);
      }
  }
  
  public void destroy()
  {
      // do nothing.
    mainflag=1;
  }
}
class question
{

public static boolean eventPics(int id) 
    {
boolean st=false;
     try{
       //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

   //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/newproj?autoReconnect=true&useSSL=false","root","manishreddy");
  PreparedStatement statement = con.prepareStatement("SELECT * FROM queDb where id="+id);
  ResultSet rs=statement.executeQuery();

    st=rs.next();

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return st;   
 }

public static String retrive(int id,int col) 
    {
String s="";
     try{
       //loading drivers for mysql
        Class.forName("com.mysql.jdbc.Driver");

   //creating connection with the database 
        Connection con=DriverManager.getConnection
                       ("jdbc:mysql://localhost:3306/newproj?autoReconnect=true&useSSL=false","root","manishreddy");
  PreparedStatement statement = con.prepareStatement("SELECT * FROM queDb where id="+id);
  ResultSet rs=statement.executeQuery();
rs.next();
    s=rs.getString(col);

     }catch(Exception e)
     {
         e.printStackTrace();
     }

    return s;   
 }
}