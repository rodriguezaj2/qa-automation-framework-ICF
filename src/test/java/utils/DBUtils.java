package utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DBUtils {

    public static List<Map<String,String >> fetch(String query){

        String dbURL=ConfigReader.read("dbURL");
        String userName=ConfigReader.read("dbUserName");
        String password=ConfigReader.read("dbPassword");

        List <Map<String,String>> tableData=new ArrayList<>();
        try(Connection connection= DriverManager.getConnection(dbURL,userName,password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery(query);
        ){
            ResultSetMetaData rsm=resultSet.getMetaData();

            while (resultSet.next()){
                Map<String,String> rowMap=new LinkedHashMap<>();
                for (int i = 1; i < rsm.getColumnCount() ; i++) {
                    String key=rsm.getColumnLabel(i);
                    String value=resultSet.getString(i);
                    rowMap.put(key,value);
                }
                tableData.add(rowMap);
            }
        }catch(SQLException sqlException){
            sqlException.printStackTrace();
        }
        return tableData;
    }

    public static Map<String, String> getLatestRecord() {
        String query = "SELECT * FROM public.\"Record\" ORDER BY id DESC LIMIT 1";
        List<Map<String, String>> recordsData = DBUtils.fetch(query);
        return recordsData.get(0);
    }

    public static Map<String, String> getRecordById(int id) {
        String query = "SELECT * FROM public.\"Record\" WHERE id = " + id;
        List<Map<String, String>> recordsData = DBUtils.fetch(query);

        if(recordsData.isEmpty()){
            return null;
        }

        return recordsData.get(0);
    }

}
