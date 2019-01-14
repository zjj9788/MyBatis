import com.isoft.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import javax.annotation.Resources;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class TestMyBatis {
    @Test
    public  void insert(){
        InputStream is = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.insert";
        List list=new ArrayList();
        User user=new User();
        user.setUname("admin");
        user.setRuname("管理员");
        user.setRemark("我是新管理员");
        list.add(user);
        User user1=new User();
        user1.setUname("Teacher");
        user1.setRuname("教师");
        user1.setRemark("我是新教师员");
        list.add(user1);
        int insert = sqlSession.insert(str, list);
        sqlSession.commit(true);
        System.out.println(insert);
    }
    public void delete(){
        InputStream is = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.delete";
        int update = sqlSession.update(str, 1);
        sqlSession.commit();
        System.out.println(1);
    }
    public void update(){
        InputStream is = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(is);
        SqlSession sqlSession = sessionFactory.openSession();
        String str = "com.isoft.mapper.UserMapper.update";
        User user=new User();
        user.setId(2);
        user.setUname("管理员");
        user.setRemark("我是管理员");
        try{
            int update = sqlSession.update(str, user);
            sqlSession.commit();
            System.out.println(1);
        }catch (Exception e){
            sqlSession.rollback();
        }

    }
    public void findAll(){
        InputStream is = TestMyBatis.class.getResourceAsStream("configuration.xml");
        SqlSessionFactory sessionFactory =new SqlSessionFactoryBuilder().build(is);
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
