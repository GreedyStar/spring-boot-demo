import com.alibaba.fastjson.JSON;
import com.greedystar.sample4.Sample4Application;
import com.greedystar.sample4.fin.dao.UserDao;
import com.greedystar.sample4.sys.dao.RoleDao;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Author GreedyStar
 * Date   2020-6-11
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Sample4Application.class)
public class Test {
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;

    @org.junit.Test
    public void test() {
        System.out.println(JSON.toJSON(userDao.findAllList()));
        System.out.println(JSON.toJSON(roleDao.findAllList()));
    }
}
