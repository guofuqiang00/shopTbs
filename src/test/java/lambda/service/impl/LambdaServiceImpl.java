package lambda.service.impl;

import com.tbs.entity.User;
import lambda.service.LambdaService;

public class LambdaServiceImpl implements LambdaService<User> {
    @Override
    public boolean show(User user) {
        return user.getUsername().equals("admin");
    }

}
