import com.kuang.dao.UserMapper;
import com.kuang.poro.User;
import com.kuang.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class MyTest {


    @Test
    public void test() {
        SqlSession session = MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
//        mapper.updateUser(new User(2,"张三","123456"));
        session.clearCache();
        System.out.println("==========================");
        User user1= mapper.queryUserById(1);
        System.out.println(user1);
        System.out.println(user==user1);
        session.close();
    }
    @Test
    public void test1() {
        SqlSession session = MybatisUtils.getSqlSession();
        SqlSession session1= MybatisUtils.getSqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        UserMapper mapper1 = session1.getMapper(UserMapper.class);
        User user = mapper.queryUserById(1);
        System.out.println(user);
        session.close();
//        mapper.updateUser(new User(2,"张三","123456"));
//        session.clearCache();
        System.out.println("==========================");
        User user1= mapper1.queryUserById(1);
        System.out.println(user1);
       System.out.println(user==user1);
        System.out.println("==========================");

        User user2= mapper1.queryUserById(2);
        System.out.println(user2);
        System.out.println(user==user1);

        session1.close();
    }
}
