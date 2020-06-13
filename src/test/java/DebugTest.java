import com.tbs.entity.User;
import org.junit.Test;

import java.util.List;

public class DebugTest {

    public void run(){
        User user = null;
        user.setUsername("xxxxxx");
        System.out.println(user);
    }


    @Test
    public void Test(){
        User user = null;

        try {
           this.run();
        }catch (Exception e){
            e.printStackTrace();
        }

    }


}
