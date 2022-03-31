package DiamonShop.Service.User;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import DiamonShop.Dao.UsersDao;
import DiamonShop.Entity.Users;

@Service
public class AccountServiceImpl implements IAccountService {

    @Autowired
    UsersDao usersDao = new UsersDao();

    @Override
    public int AddAccount(Users user) {
        //Mã hóa mật khẩu người dùng
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(12)));
        return usersDao.AddAccount(user);
    }

    @Override
    public Users CheckAccount(Users user) {
        String pass = user.getPassword();
        user = usersDao.GetUserByAccount(user);
        if (user != null) {
            //Giải mã mật khẩu người dùng và kiểm tra
            if (BCrypt.checkpw(pass, user.getPassword())) {
                return user;
            } else {
                return null;
            }
        }
        return null;
    }
}
