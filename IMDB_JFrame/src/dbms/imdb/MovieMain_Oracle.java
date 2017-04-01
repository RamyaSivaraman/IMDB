package dbms.imdb;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class MovieMain_Oracle {

    public static void main(String[] args) {
        try {      
            System.out.println("Oracle JDBC Driver Registered!");

            Connection myConn = null;

            try {

                myConn = DriverManager.getConnection(
                        "jdbc:oracle:thin:@localhost:1521:orcl", "hr",
                        "hr");
            } catch (SQLException e) {

                System.out.println("Connection Failed! Check output console");
                e.printStackTrace();
                return;

            }
            String deletemoviequery = "DELETE FROM MOVIE";
           // Statement stmt = myConn.createStatement();
            PreparedStatement pstmt = myConn.prepareStatement(deletemoviequery);
            pstmt.executeUpdate();
            String query = " INSERT INTO MOVIE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = myConn.prepareStatement(query);
            final int batchSize = 10000;
            int count = 0;
            long startTime = System.currentTimeMillis();
            ArrayList<Movie> gto = getTestObj(args[0]);
            System.out.println("Time Taken for getTestObj " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto.size());
            for (int i = 0; i < gto.size(); i++) {

                preparedStatement.setInt(1, gto.get(i).getMovie_id());
                preparedStatement.setString(2, gto.get(i).getTitle());
                preparedStatement.setInt(3, gto.get(i).getIMDBID());
                preparedStatement.setString(4, gto.get(i).getSpanish_title());
                preparedStatement.setString(5, gto.get(i).getIMBDpicURL());
                preparedStatement.setInt(6, gto.get(i).getYear());
                preparedStatement.setString(7, gto.get(i).getRtID());
                preparedStatement.setDouble(8, gto.get(i).getRtarating());
                preparedStatement.setInt(9, gto.get(i).getRtarev());
                preparedStatement.setInt(10, gto.get(i).getRtafresh());
                preparedStatement.setInt(11, gto.get(i).getRtarotten());
                preparedStatement.setInt(12, gto.get(i).getRtaavg());
                preparedStatement.setDouble(13, gto.get(i).getRttrating());
                preparedStatement.setInt(14, gto.get(i).getRttrev());
                preparedStatement.setInt(15, gto.get(i).getRttfresh());
                preparedStatement.setInt(16, gto.get(i).getRttrotten());
                preparedStatement.setInt(17, gto.get(i).getRttavg());
                preparedStatement.setDouble(18, gto.get(i).getRtaudirating());
                preparedStatement.setInt(19, gto.get(i).getRtaudinum());
                preparedStatement.setInt(20, gto.get(i).getRtaudiavg());
                preparedStatement.setString(21, gto.get(i).getRtpicurl());

                //  preparedStatement.executeUpdate();
                preparedStatement.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement.executeBatch();
                }                
            }
            preparedStatement.executeBatch();
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            String deletemovie_genrequery = "DELETE FROM MOVIE_GENRE";

            pstmt = myConn.prepareStatement(deletemovie_genrequery);
            pstmt.executeUpdate();

            query = " INSERT INTO MOVIE_GENRE VALUES (?,?)";
            PreparedStatement preparedStatement2 = myConn.prepareStatement(query);
            count = 0;
            
            startTime = System.currentTimeMillis();
            ArrayList<Movie_Genres> gto2 = getTestObj2(args[1]);
            System.out.println("Time Taken for getTestObj2 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto2.size());

            for (int i = 0; i < gto2.size(); i++) {
                preparedStatement2.setInt(1, gto2.get(i).getMovie_id());
                preparedStatement2.setString(2, gto2.get(i).getGenres());
                //  preparedStatement2.executeUpdate();
                preparedStatement2.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement2.executeBatch();
                }                
            }
            preparedStatement2.executeBatch();
            String deletemovie_Actorquery = "DELETE FROM MOVIE_ACTOR";

             pstmt = myConn.prepareStatement(deletemovie_Actorquery);
            pstmt.executeUpdate();

            query = " INSERT INTO MOVIE_ACTOR VALUES (?,?,?,?)";
            PreparedStatement preparedStatement3 = myConn.prepareStatement(query);
           // final int batchsize2 = 10000;
            count = 0;

            startTime = System.currentTimeMillis();
            ArrayList<Movie_Actors> gto3 = getTestObj3(args[2]);
            System.out.println("Time Taken for getTestObj3 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto3.size());

            for (int i = 0; i < gto3.size(); i++) {
                preparedStatement3.setInt(1, gto3.get(i).getMovie_id());
                preparedStatement3.setString(2, gto3.get(i).getActor_id());
                preparedStatement3.setString(3, gto3.get(i).getActorName());
                preparedStatement3.setInt(4, gto3.get(i).getRanking());
                // preparedStatement3.executeUpdate();
                preparedStatement3.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement3.executeBatch();
                }                
            }
            preparedStatement3.executeBatch();
            String deletemovie_Countryquery = "DELETE FROM MOVIE_COUNTRY";

            pstmt = myConn.prepareStatement(deletemovie_Countryquery);
            pstmt.executeUpdate();
            
            query = " INSERT INTO MOVIE_COUNTRY VALUES (?,?)";
            PreparedStatement preparedStatement4 = myConn.prepareStatement(query);
            //final int batchsize3 = 10000;
            count = 0;
            startTime = System.currentTimeMillis();
            ArrayList<Movie_Country> gto4 = getTestObj4(args[3]);
            System.out.println("Time Taken for getTestObj4 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto4.size());

            for (int i = 0; i < gto4.size(); i++) {
                preparedStatement4.setInt(1, gto4.get(i).getMovie_id());
                preparedStatement4.setString(2, gto4.get(i).getCountry());

                //preparedStatement4.executeUpdate();
                preparedStatement4.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement4.executeBatch();
                }               
            }
            preparedStatement4.executeBatch();
            String deletemovie_Directorquery = "DELETE FROM MOVIE_DIRECTOR";

             pstmt = myConn.prepareStatement(deletemovie_Directorquery);
             pstmt.executeUpdate();

            query = " INSERT INTO MOVIE_DIRECTOR VALUES (?,?,?)";
            PreparedStatement preparedStatement5 = myConn.prepareStatement(query);
            //final int batchsize4 = 10000;
            count = 0;
            startTime = System.currentTimeMillis();
            ArrayList<Movie_Director> gto5 = getTestObj5(args[4]);
            System.out.println("Time Taken for getTestObj5 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto5.size());

            for (int i = 0; i < gto5.size(); i++) {
                preparedStatement5.setInt(1, gto5.get(i).getMovie_id());
                preparedStatement5.setString(2, gto5.get(i).getDirector_id());
                preparedStatement5.setString(3, gto5.get(i).getDirectorName());
                //System.out.println("StrinLIne:MovId: " + gto5.get(i).getMovie_id() + " directorId: " + gto5.get(i).getDirector_id() + " DName: " + gto5.get(i).getDirectorName());
                // preparedStatement5.executeUpdate();
                preparedStatement5.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement5.executeBatch();
                }               
            }
             preparedStatement5.executeBatch();
            /*
            String deletemovie_Location = "DELETE FROM MOVIE_LOCATION";

            stmt.execute(deletemovie_Location);

            query = " INSERT INTO MOVIE_LOCATION VALUES (?,?,?,?,?)";
            PreparedStatement preparedStatement6 = myConn.prepareStatement(query);
            ArrayList<Movie_Location> gto6 = getTestObj6("C:\\Users\\Ramya Sivaraman\\Desktop\\Assign3\\movie_locations.dat");
            for (int i = 0; i < gto6.size(); i++) {
                preparedStatement6.setInt(1, gto6.get(i).getMovie_id());
                preparedStatement6.setString(2, gto6.get(i).getCountry());
                preparedStatement6.setString(3, gto6.get(i).getState());
                preparedStatement6.setString(4, gto6.get(i).getCity());
                preparedStatement6.setString(5, gto6.get(i).getStreet());
                
                preparedStatement6.executeUpdate();
            }*/

            String deletetags = "DELETE FROM TAGS";
            pstmt = myConn.prepareStatement(deletetags);
            pstmt.executeUpdate();
            

            query = " INSERT INTO TAGS VALUES (?,?)";
            PreparedStatement preparedStatement7 = myConn.prepareStatement(query);
           // final int batchsize5 = 10000;
            count = 0;
            startTime = System.currentTimeMillis();
            ArrayList<Tags> gto7 = getTestObj7(args[5]);
            System.out.println("Time Taken for getTestObj7 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto7.size());

            for (int i = 0; i < gto7.size(); i++) {
                preparedStatement7.setInt(1, gto7.get(i).getTag_id());
                preparedStatement7.setString(2, gto7.get(i).getTag_text());
                // preparedStatement7.executeUpdate();
                preparedStatement7.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement7.executeBatch();
                }                
            }
            preparedStatement7.executeBatch();

            String deletemovie_Tags = "DELETE FROM MOVIE_TAGS";

             pstmt = myConn.prepareStatement(deletemovie_Tags);
            pstmt.executeUpdate();

            query = " INSERT INTO MOVIE_TAGS VALUES (?,?,?)";
            PreparedStatement preparedStatement8 = myConn.prepareStatement(query);
           // final int batchsize6 = 10000;
            count = 0;

            startTime = System.currentTimeMillis();
            ArrayList<Movie_Tags> gto8 = getTestObj8(args[6]);
            System.out.println("Time Taken for getTestObj8 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto8.size());
            for (int i = 0; i < gto8.size(); i++) {
                preparedStatement8.setInt(1, gto8.get(i).getTag_id());
                preparedStatement8.setInt(2, gto8.get(i).getMovie_id());
                preparedStatement8.setInt(3, gto8.get(i).getTag_weight());
                // preparedStatement8.executeUpdate();
                preparedStatement8.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement8.executeBatch();
                }                
            }
            preparedStatement8.executeBatch();
            String deleteuser_ratings = "DELETE FROM USER_RATINGS";

             pstmt = myConn.prepareStatement(deleteuser_ratings);
            pstmt.executeUpdate();

            query = " INSERT INTO USER_RATINGS VALUES (?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement9 = myConn.prepareStatement(query);
           // final int batchSize = 10000;
            count = 0;
            startTime = System.currentTimeMillis();
            ArrayList<Movie_UserRatings> gto9 = getTestObj9(args[7]);
            System.out.println("Time Taken for getTestObj9 " + (System.currentTimeMillis() - startTime));
            System.out.println("size" + gto9.size());

            for (int i = 0; i < gto9.size(); i++) {
                preparedStatement9.setInt(1, gto9.get(i).getUserid());
                preparedStatement9.setInt(2, gto9.get(i).getMovie_id());
                preparedStatement9.setDouble(3, gto9.get(i).getRatings());
                preparedStatement9.setInt(4, gto9.get(i).getDay());
                preparedStatement9.setInt(5, gto9.get(i).getMonth());
                preparedStatement9.setInt(6, gto9.get(i).getYear());
                preparedStatement9.setInt(7, gto9.get(i).getHr());
                preparedStatement9.setInt(8, gto9.get(i).getMin());
                preparedStatement9.setInt(9, gto9.get(i).getSec());

                // preparedStatement9.executeUpdate();
                preparedStatement9.addBatch();

                if (++count % batchSize == 0) {
                    preparedStatement9.executeBatch();
                }                
            }
            preparedStatement9.executeBatch();

        } catch (Exception e) {
            System.out.println(" error");
            e.printStackTrace();
        }


    }

    public static ArrayList<Movie> getTestObj(String Filepath) throws Exception{
        File file = new File(Filepath);
        ArrayList<Movie> listResult = new ArrayList<Movie>();

      

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            //skipping the header
            String line = sc.nextLine();
            //  int i = 0;
            while (sc.hasNextLine()) {
                line = sc.nextLine();
                // i++;
                //   System.out.println("LineNum: "+i+" LineText: "+line);
                String[] column = line.split("\t");

                Movie ob = new Movie();

                ob.setMovie_id(Integer.parseInt(column[0]));
                ob.setTitle(column[1]);
                ob.setIMDBID(Integer.parseInt(column[2]));
                ob.setSpanish_title(column[3]);
                ob.setIMBDpicURL(column[4]);
                ob.setYear(Integer.parseInt(column[5]));
                if (column[6] != null && !column[6].equals(" ") && !column[6].equals("\\N")) {
                    ob.setRtID(column[6]);
                }
                if (column[7] != null && !column[7].equals(" ") && !column[7].equals("\\N")) {
                    ob.setRtarating(Double.parseDouble(column[7]));
                }
                if (column[8] != null && !column[8].equals(" ") && !column[8].equals("\\N")) {
                    ob.setRtarev(Integer.parseInt(column[8]));
                }
                if (column[9] != null && !column[9].equals(" ") && !column[9].equals("\\N")) {
                    ob.setRtafresh(Integer.parseInt(column[9]));
                }
                if (column[10] != null && !column[10].equals(" ") && !column[10].equals("\\N")) {
                    ob.setRtarotten(Integer.parseInt(column[10]));
                }
                if (column[11] != null && !column[11].equals(" ") && !column[11].equals("\\N")) {
                    ob.setRtaavg(Integer.parseInt(column[11]));
                }
                if (column[12] != null && !column[12].equals(" ") && !column[12].equals("\\N")) {
                    ob.setRttrating(Double.parseDouble(column[12]));
                }
                if (column[13] != null && !column[13].equals(" ") && !column[13].equals("\\N")) {
                    ob.setRttrev(Integer.parseInt(column[13]));
                }
                if (column[14] != null && !column[14].equals(" ") && !column[14].equals("\\N")) {
                    ob.setRttfresh(Integer.parseInt(column[14]));

                }
                if (column[15] != null && !column[15].equals(" ") && !column[15].equals("\\N")) {
                    ob.setRttrotten(Integer.parseInt(column[15]));

                }
                if (column[16] != null && !column[16].equals(" ") && !column[16].equals("\\N")) {
                    ob.setRttavg(Integer.parseInt(column[16]));

                }
                if (column[17] != null && !column[17].equals(" ") && !column[17].equals("\\N")) {
                    ob.setRtaudirating(Double.parseDouble(column[17]));

                }
                if (column[18] != null && !column[18].equals(" ") && !column[18].equals("\\N")) {
                    ob.setRtaudinum(Integer.parseInt(column[18]));

                }
                if (column[19] != null && !column[19].equals(" ") && !column[19].equals("\\N")) {
                    ob.setRtaudiavg(Integer.parseInt(column[19]));

                }
                if (column[20] != null && !column[20].equals(" ") && !column[20].equals("\\N")) {
                    ob.setRtpicurl(column[20]);

                }

                listResult.add(ob);

            }
            sc.close();

       
        return listResult;

    }

    public static ArrayList<Movie_Genres> getTestObj2(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_Genres> listResult = new ArrayList<Movie_Genres>();

        try {

            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //System.out.println("Line " + line);
                String[] column = line.split("\t");

                Movie_Genres ob = new Movie_Genres();

                ob.setMovie_id(Integer.parseInt(column[0]));
                ob.setGenres(column[1]);
                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }

    public static ArrayList<Movie_Actors> getTestObj3(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_Actors> listResult = new ArrayList<Movie_Actors>();

        try {

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println("Line " + line);
                String[] column = line.split("\t");

                Movie_Actors ob = new Movie_Actors();

                ob.setMovie_id(Integer.parseInt(column[0]));
                ob.setActor_id(column[1]);
                ob.setActorName(column[2]);
                ob.setRanking(Integer.parseInt(column[3]));

                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }

    public static ArrayList<Movie_Country> getTestObj4(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_Country> listResult = new ArrayList<Movie_Country>();

        try {

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();

                //System.out.println("Line " + line);
                String[] column = line.split("\t");
                if (column.length < 2) {
                    continue;
                }
                Movie_Country ob = new Movie_Country();
                //System.out.println("ArraySize: "+column.length);
                //System.out.println("Col0 "+column[0]);

                // System.out.println("Col1 "+column[1]);
                ob.setMovie_id(Integer.parseInt(column[0]));
                //if (column[1] != null && !column[1].equals(" ") && !column[1].equals("\\N")) {
                ob.setCountry(column[1]);
                //          }
                //if (column[1] != null && !column[1].equals(" ")){

                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }

    public static ArrayList<Movie_Director> getTestObj5(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_Director> listResult = new ArrayList<Movie_Director>();

        try {

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                // System.out.println("Line " + line);
                String[] column = line.split("\t");

                Movie_Director ob = new Movie_Director();

                ob.setMovie_id(Integer.parseInt(column[0]));
                ob.setDirector_id(column[1]);
                ob.setDirectorName(column[2]);

                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }

    /* public static ArrayList<Movie_Location> getTestObj6(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_Location> listResult = new ArrayList<Movie_Location>();

        try {

            Scanner sc = new Scanner(file);
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //System.out.println("Line " + line);
                String[] column = line.split("\t");

                Movie_Location ob = new Movie_Location();

                ob.setMovie_id(Integer.parseInt(column[0]));
                ob.setCountry(column[1]);
                ob.setState(column[2]);
                ob. setCity(column[3]);
                ob.setStreet(column[4]);
                
                
                
                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }*/
    public static ArrayList<Tags> getTestObj7(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Tags> listResult = new ArrayList<Tags>();

        try {

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                //System.out.println("Line " + line);
                String[] column = line.split("\t");

                Tags ob = new Tags();

                // System.out.println("ArraySize: "+column.length);
                // System.out.println("Col0 "+column[0]);
                //System.out.println("Col1 "+column[1]);
                //System.out.println("Line:"+ line);
                ob.setTag_id(Integer.parseInt(column[0]));
                ob.setTag_text(column[1]);
                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }

    public static ArrayList<Movie_Tags> getTestObj8(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_Tags> listResult = new ArrayList<Movie_Tags>();

        try {

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
              //  System.out.println("Line " + line);
                String[] column = line.split("\t");

                Movie_Tags ob = new Movie_Tags();
                ob.setTag_id(Integer.parseInt(column[0]));
                ob.setMovie_id(Integer.parseInt(column[1]));
                ob.setTag_weight(Integer.parseInt(column[2]));

                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }

    public static ArrayList<Movie_UserRatings> getTestObj9(String Filepath) {
        File file = new File(Filepath);
        ArrayList<Movie_UserRatings> listResult = new ArrayList<Movie_UserRatings>();

        try {

            Scanner sc = new Scanner((new FileInputStream(Filepath)), "UTF-8");
            sc.nextLine();
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
               // System.out.println("Line " + line);
                String[] column = line.split("\t");

                Movie_UserRatings ob = new Movie_UserRatings();
                ob.setUserid(Integer.parseInt(column[0]));
                ob.setMovie_id(Integer.parseInt(column[1]));
                ob.setRatings(Double.parseDouble(column[2]));
                ob.setDay(Integer.parseInt(column[3]));
                ob.setMonth(Integer.parseInt(column[4]));
                ob.setYear(Integer.parseInt(column[5]));
                ob.setHr(Integer.parseInt(column[6]));
                ob.setMin(Integer.parseInt(column[7]));
                ob.setSec(Integer.parseInt(column[8]));

                listResult.add(ob);

            }
            sc.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return listResult;

    }
}
