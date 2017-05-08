/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package evoting;

import java.sql.*;

public class DB {
    public static Connection connect(){
        try{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/voting","root","");  
        return con;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
  public static String[] getColumn(String table,String column){
     try {
            String query = "select " +column+ " from "+table+"";
            PreparedStatement st = connect().prepareStatement(query);
            ResultSet rs = st.executeQuery();
            String[] result = new String[30];
            int i = 0;
            while (rs.next()) {
                result[i] = rs.getString(column);
                i++;
            }
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
 }
   public static String getResult(String table,String column,String condition){
       try{
           String query="select "+column+" from "+table+" where "+condition+"";
           PreparedStatement st=connect().prepareStatement(query);
           ResultSet result=st.executeQuery();
           while(result.next())
               return result.getString(column);
       }catch(Exception e){
           e.printStackTrace();
       }
       return null;
   }
   public static String[] getRow(String table,int columnCount,String condition){      
       String[] row=new String[columnCount];
       try{
       String query="select * from "+table+" where "+condition+"";
       PreparedStatement st=connect().prepareStatement(query);
       ResultSet result=st.executeQuery();
       if(result.next()){
          for(int i=0;i<columnCount;i++){
              row[i]=result.getString(i+1);
          }
       }
       return row;
    }catch(Exception e){
        e.printStackTrace();
    }
    return row;
   }
   public static String[] getRow(String table,String[] column,String condition){      
       String[] row=new String[column.length];
       try{
       String query="select * from "+table+" where "+condition+"";
       PreparedStatement st=connect().prepareStatement(query);
       ResultSet result=st.executeQuery();
       if(result.next()){
          for(int i=0;i<column.length;i++){
              row[i]=result.getString(column[i]);
          }
       }
    }catch(Exception e){
        e.printStackTrace();
    }
    return row;
   }
   public static String[][] getTable(String table,int columnCount){
       try{
           String query="select * from "+table+"";
           PreparedStatement st=connect().prepareStatement(query);
           ResultSet rs=st.executeQuery();
           String[][] result=new String[40][11];
           int i=0;
           while(rs.next()){
               int j=0;
               int k=1;
               while(j<columnCount){
                   result[i][j]=rs.getString(k);
                   j++;
                   k++;
               }
               i++;
           }
           return result;
       }catch(Exception e){e.printStackTrace();}
       return null;
   }
        public static boolean executeUpdate(String query){
     try{
            PreparedStatement st=connect().prepareStatement(query);
            int i=st.executeUpdate();
            return i<1? false:true;
        }catch(Exception e){
            e.printStackTrace();
        }
     return false;
 }
  public static boolean update(String table,String column,String val,String condition){
      try{
      String query="update "+table+" set "+column+"='"+val+"' where "+condition+"";
      PreparedStatement st=connect().prepareStatement(query);
      int x=st.executeUpdate();
      return x>=1;
      }catch(Exception ex){
          ex.printStackTrace();
      }
      return false;
  } 
    public static void delete(String table,String pk,String value){
        try{
         String query="delete from "+table+" where "+pk+"='"+value+"'";
            PreparedStatement st=connect().prepareStatement(query);
            st.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }   
}
}
