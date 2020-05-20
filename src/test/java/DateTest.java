import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.SimpleFormatter;

public class DateTest {
    public static void main(String[] args) throws ParseException {

        String beginTime=new String("2020-05-19 20:00:00");
        String endTime=new String("2020-05-19 20:00:00");

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date sd1=df.parse(beginTime);
        Date sd2=df.parse(endTime);

        Date date1 = new Date();
        Date date2 = new Date();
//        System.out.println(sd1.before(sd2));
//        System.out.println(sd1.after(sd2));
        System.out.println(date1.equals(date2));
        System.out.println(date1.compareTo(date1));
    }
}
