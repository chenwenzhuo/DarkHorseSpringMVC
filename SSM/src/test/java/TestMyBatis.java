import com.heythere.dao.AccountDao;
import com.heythere.domain.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMyBatis {
    @Test
    public void testFindAll() throws IOException {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        //查询所有数据
        List<Account> accounts = dao.findAll();
        for (Account account : accounts) {
            System.out.println(account);
        }

        //关闭资源
        session.close();
        inputStream.close();
    }

    @Test
    public void testSave() throws IOException {
        //加载配置文件
        InputStream inputStream = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建SqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //创建SqlSession对象
        SqlSession session = sqlSessionFactory.openSession();
        //获取代理对象
        AccountDao dao = session.getMapper(AccountDao.class);

        //创建一个Account对象
        Account newAccount = new Account();
        newAccount.setName("jane");
        newAccount.setMoney(123.4);
        //执行sql保存数据
        dao.saveAccount(newAccount);
        //提交事务
        session.commit();

        //关闭资源
        session.close();
        inputStream.close();
    }
}
