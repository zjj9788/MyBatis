import com.isoft.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void findAll(){
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.findAll";
        List<Object> objects = sqlSession.selectList(str);
        for (Object obj:objects) {
            User user= (User) obj;
            System.out.println(user.getUname());
            System.out.println(user.getRuname());
            System.out.println("------------");
        }
    }
    public  void findUserById() {
        InputStream rs = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(rs);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.findUserById";
        User o = (User)sqlSession.selectOne(str,2);
        System.out.println(o);


    }
}
