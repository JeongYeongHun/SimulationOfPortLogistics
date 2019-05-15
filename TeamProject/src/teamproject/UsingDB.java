package teamproject;

/**
 *
 * @author 정영훈
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.StringTokenizer;


public class UsingDB implements SaveLoadWay{

    @Override
    public void save(String str) {
        Connection conn   = null;   //데이터베이스 연결을 위한 선언
        PreparedStatement pstmt = null;
        
        StringTokenizer tokenizer = new StringTokenizer(str);
        String strId = tokenizer.nextToken(" ");    //화물 id
        String strDestination = tokenizer.nextToken(" ");    //목적지
        String strDate = tokenizer.nextToken(" ");    //등록일
        String strLocation = tokenizer.nextToken(" ");    //위치
        String strType = tokenizer.nextToken(" ");    //화물종류
        String strBubble = tokenizer.nextToken(" ");    //에어캡 개수
        String strPaper = tokenizer.nextToken(" ");    //종이포장 개수
        String strCost = tokenizer.nextToken(" ");    //비용
        
        try
        {
            String jdbcUrl  = "";	//db 주소
            String dbId  = "";	//아이디
            String dbPass = "";	//비밀번호
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
            
            String sql = "insert into goods values (?,?,?,?,?,?,?,?)";          // sql 쿼리
            pstmt = conn.prepareStatement(sql);     //prepareStatement에서 sql쿼리문을 미리 컴파일
            pstmt.setString(1,strId);       //sql쿼리 값 세팅
            pstmt.setString(2,strDestination);
            pstmt.setString(3,strDate);
            pstmt.setString(4,strLocation);
            pstmt.setString(5,strType);
            pstmt.setString(6,strBubble);
            pstmt.setString(7,strPaper);
            pstmt.setString(8,strCost);
            pstmt.executeUpdate();
            conn.commit();
        }catch(Exception e){
                e.printStackTrace();
        }finally{
            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){}
            if(conn!=null)try{conn.close();}catch(SQLException sqle){}
        }
    }

    @Override
    public String load(String str, int index1, int index2) {    //비교할 문자, str와 비교할 인덱스, 리턴할 인덱스
        Connection conn   = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";
        String result = "";
        
        switch(index2){
            case 0:
                sql = "select id from goods where ";
                break;
            case 1:
                sql = "select destination from goods where ";
                break;
            case 2:
                sql = "select registration_date from goods where ";
                break;
            case 3:
                sql = "select location from goods where ";
                break;
            case 4:
                sql = "select type from goods where ";
                break;
            case 5:
                sql = "select bubble from goods where ";
                break;
            case 6:
                sql = "select paper from goods where ";
                break;
            case 7:
                sql = "select cost from goods where ";
                break;
        }
        
        switch(index1){
            case 0:
                sql = sql+"id = ?";
                break;
            case 1:
                sql = sql+"destination = ?";
                break;
            case 2:
                sql = sql+"registration_date = ?";
                break;
            case 3:
                sql = sql+"location = ?";
                break;
            case 4:
                sql = sql+"type = ?";
                break;
            case 5:
                sql = sql+"bubble = ?";
                break;
            case 6:
                sql = sql+"paper = ?";
                break;
            case 7:
                sql = sql+"cost = ?";
                break;
        }
        
        try
        {
            String jdbcUrl  = "";	//db 주소
            String dbId  = "";	//아이디
            String dbPass = "";	//비밀번호
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,str);
            rs = pstmt.executeQuery();
            
            if(rs.next()){      //조회한 값이 존재하는지 체크
                switch(index2){
                    case 0:
                        result = rs.getString("ID");
                        break;
                    case 1:
                        result = rs.getString("DESTINATION");
                        break;
                    case 2:
                        result = rs.getString("REGISTRATION_DATE");
                        break;
                    case 3:
                        result = rs.getString("LOCATION");
                        break;
                    case 4:
                        result = rs.getString("TYPE");
                        break;
                    case 5:
                        result = rs.getString("BUBBLE");
                        break;
                    case 6:
                        result = rs.getString("PAPER");
                        break;
                    case 7:
                        result = rs.getString("COST");
                        break;
                }
                return result;
            }
            
        }catch(Exception e){
                e.printStackTrace();
        }finally{
            if(rs!=null)try{rs.close();}catch(SQLException sqle){}
            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){}
            if(conn!=null)try{conn.close();}catch(SQLException sqle){}
        }
        
        return "";
    }

    @Override
    public void modifyFile(String oldString, String newString) {
        Connection conn   = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "";
        
        try
        {
            String jdbcUrl  = "";	//db 주소
            String dbId  = "";	//아이디
            String dbPass = "";	//비밀번호
            
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(jdbcUrl,dbId,dbPass);
            
            sql = "update goods set location=? where location=?";
            pstmt = conn.prepareStatement(sql);     //prepareStatement에서 sql쿼리문을 미리 컴파일
            pstmt.setString(1,newString);       //sql쿼리 값 세팅
            pstmt.setString(2,oldString);
            pstmt.executeUpdate();
            conn.commit();
            
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            if(rs!=null)try{rs.close();}catch(SQLException sqle){}
            if(pstmt!=null)try{pstmt.close();}catch(SQLException sqle){}
            if(conn!=null)try{conn.close();}catch(SQLException sqle){}
        }
    }
}
