import com.test.generator.dao.HrMapper;
import com.test.generator.entity.Hr;
import com.test.generator.jpa.HrJPA;
import org.hibernate.criterion.Example;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @作者 usts4
 * @Github mingliantianxi
 * @时间 2020/7/27
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.test.generator.dao")
public class MybatisApplicationTests {
    @Autowired
    private HrMapper hrMapper;

    @Autowired
    private HrJPA hrJPA;

    @Test
    public void contextLoads() {
        System.out.println(hrMapper.selectByPrimaryKey(11));//mybatis方式
        System.out.println(hrJPA.findById(11));//JPA方式
    }
}
