import com.tbs.dao.user.UserDao;
import com.tbs.entity.User;
import com.tbs.tools.BaseTest;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.ws.Action;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test extends BaseTest {

   @Autowired
   private UserDao userDao;

    @org.junit.Test
    public void select(){
        Map<String,Object> map = new HashMap<>();
        map.put("username","admin");
        map.put("id",1867494225);
        //List<User> users = userDao.selectUserByMap(map);
        List<User> users = userDao.selectUserByMap2(map);
        System.out.println(users);

    }



}
