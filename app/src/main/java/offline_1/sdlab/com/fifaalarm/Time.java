package offline_1.sdlab.com.fifaalarm;
import java.util.jar.Attributes.Name;
public class Time {
        int _id;
        String _year;
        String _month;
        String _day;
        String _hour;
        String _minute;

        public Time()
        {

        }
        public Time(int id,String year,String month,String day,String hour,String minute)
        {

            this._id=id;
            this._year=year;
            this._month=month;
            this._day=day;
            this._hour=hour;
            this._minute=minute;

        }
   public Time(String year,String month,String day,String hour,String minute)
    {

        this._year=year;
        this._month=month;
        this._day=day;
        this._hour=hour;
        this._minute=minute;

    }

/*
    public Time(int id,String hour,String minute)
    {
        this._id=id;
        this._hour=hour;
        this._minute=minute;
    }*/
    /*
        public  Time getIdHourMinute(){
            return new Time(getId(),getHour(),getMinute());
        }
    */
        public int getId()
        {
            return this._id;
        }
        public void setId(int Id)
        {
            this._id=Id;
        }

        public String getYear()
        {
            return this._year;
        }
        public void setYear(String year)
        {
            this._year=year;
        }

        public String getMonth()
        {
            return this._month;
        }
        public void setMonth(String month)
        {
            this._month=month;
        }

        public String getDay()
        {
            return this._day;
        }
        public void setDay(String day)
        {
            this._day=day;
        }

        public String getHour()
        {
            return this._hour;
        }
        public void setHour(String hour)
        {
            this._hour=hour;
        }

        public String getMinute()
        {
            return this._minute;
        }
        public void setMinute(String minitue)
        {
            this._minute=minitue;
        }




}
