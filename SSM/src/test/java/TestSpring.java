import com.heythere.service.AccountService;
import com.heythere.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestSpring {
    @Test
    public void test1() {
        //加载配置文件
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");

        //获取对象
        AccountService accountService = (AccountServiceImpl) context.getBean("accountService");
        accountService.findAll();
    }
}
