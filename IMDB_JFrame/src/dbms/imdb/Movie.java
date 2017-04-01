package dbms.imdb;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ramya Sivaraman
 */
public class Movie {

    int movie_id;
    String Title;
    int IMDBID;
    String Spanish_title;
    String IMBDpicURL;
    int Year;
    String rtID;
    double rtarating;
    int rtarev;
    int rtafresh;
    int rtarotten;
    int rtaavg;
    double rttrating;
    int rttrev;
    int rttfresh;
    int rttrotten;
    int rttavg;
    double rtaudirating;
    int rtaudinum;
    int rtaudiavg;
    String rtpicurl;

    public Movie() {

    }


    /*public Movie (int movieid, String Title,int  IMDBID,String Spanish_title,String IMBDpicURL,String Year,String rtID,double rtarating,int rtarev,int rtafresh,int rtarotten,int rtaavg,double rttrating,int rttrev,int rttfresh,int rttrotten,int rttavg,double rtaudirating,int rtaudinum,int rtaudiavg,String rtpicurl ) {
	this.movie_id = movieid;
	this.Title = Title;
	this.IMDBID = IMDBID;
	this.Spanish_title=Spanish_title;
	this.IMBDpicURL = IMBDpicURL;
	this.Year = Year;
	this.rtID= rtID;
	this.rtarating =rtarating;
	this.rtarev= rtarev;
	this.rtafresh= rtafresh;
	this.rtarotten=rtarotten;
	this.rtaavg=rtaavg;
	this.rttrating=rttrating;
    this.rttrev=rttrev;
	this.rttfresh=rttfresh;
	this.rttrotten=rttrotten;
	this.rttavg=rttavg;
	this.rtaudirating=rtaudirating;
	this.rtaudinum=rtaudinum;
	this.rtaudiavg=rtaudiavg;
	this.rtpicurl=rtpicurl;
	
	
}*/
    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getIMDBID() {
        return IMDBID;
    }

    public void setIMDBID(int iMDBID) {
        IMDBID = iMDBID;
    }

    public String getSpanish_title() {
        return Spanish_title;
    }

    public void setSpanish_title(String spanish_title) {
        Spanish_title = spanish_title;
    }

    public String getIMBDpicURL() {
        return IMBDpicURL;
    }

    public void setIMBDpicURL(String iMBDpicURL) {
        IMBDpicURL = iMBDpicURL;
    }

    public int getYear() {
        return Year;
    }

    public void setYear(int year) {
        Year = year;
    }

    public String getRtID() {
        return rtID;
    }

    public void setRtID(String rtID) {
        this.rtID = rtID;
    }

    public double getRtarating() {
        return rtarating;
    }

    public void setRtarating(double rtarating) {
        this.rtarating = rtarating;
    }

    public int getRtarev() {
        return rtarev;
    }

    public void setRtarev(int rtarev) {
        this.rtarev = rtarev;
    }

    public int getRtafresh() {
        return rtafresh;
    }

    public void setRtafresh(int rtafresh) {
        this.rtafresh = rtafresh;
    }

    public int getRtarotten() {
        return rtarotten;
    }

    public void setRtarotten(int rtarotten) {
        this.rtarotten = rtarotten;
    }

    public int getRtaavg() {
        return rtaavg;
    }

    public void setRtaavg(int rtaavg) {
        this.rtaavg = rtaavg;
    }

    public double getRttrating() {
        return rttrating;
    }

    public void setRttrating(double rttrating) {
        this.rttrating = rttrating;
    }

    public int getRttrev() {
        return rttrev;
    }

    public void setRttrev(int rttrev) {
        this.rttrev = rttrev;
    }

    public int getRttfresh() {
        return rttfresh;
    }

    public void setRttfresh(int rttfresh) {
        this.rttfresh = rttfresh;
    }

    public int getRttrotten() {
        return rttrotten;
    }

    public void setRttrotten(int rttrotten) {
        this.rttrotten = rttrotten;
    }

    public int getRttavg() {
        return rttavg;
    }

    public void setRttavg(int rttavg) {
        this.rttavg = rttavg;
    }

    public double getRtaudirating() {
        return rtaudirating;
    }

    public void setRtaudirating(double rtaudirating) {
        this.rtaudirating = rtaudirating;
    }

    public int getRtaudinum() {
        return rtaudinum;
    }

    public void setRtaudinum(int rtaudinum) {
        this.rtaudinum = rtaudinum;
    }

    public int getRtaudiavg() {
        return rtaudiavg;
    }

    public void setRtaudiavg(int rtaudiavg) {
        this.rtaudiavg = rtaudiavg;
    }

    public String getRtpicurl() {
        return rtpicurl;
    }

    public void setRtpicurl(String rtpicurl) {
        this.rtpicurl = rtpicurl;
    }

}
