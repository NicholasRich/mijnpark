import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.text.csv.*;
import cn.hutool.core.util.StrUtil;
import com.boyang.landsense.common.entity.LandSense;
import com.boyang.landsense.common.repo.LandSenseRepo;
import com.boyang.landsense.avg.SenseAvgApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@SpringBootTest(classes = SenseAvgApplication.class)
public class DataGenerator {
    @Autowired
    private LandSenseRepo landSenseRepo;

    @Test
    public void test1() {
        CsvReader reader = CsvUtil.getReader(new CsvReadConfig().setContainsHeader(true));
//从文件中读取CSV数据
        CsvData data = reader.read(FileUtil.file("D:\\Projects\\mijnpark\\MijnPark-Amsterdam-LandSense.csv"));

        List<CsvRow> rows = data.getRows();
        List<LandSense> landSenseList = new ArrayList<>();
        for (CsvRow row : rows) {
            Map<String, String> fieldMap = row.getFieldMap();
            fieldMap.forEach(new BiConsumer<String, String>() {
                @Override
                public void accept(String s, String s2) {
                    if (StrUtil.isBlank(s2)) {
                        fieldMap.put(s, null);
                    }
                }
            });
            LandSense landSense = BeanUtil.fillBeanWithMap(fieldMap, new LandSense(), true, false);
            landSenseList.add(landSense);
        }
        landSenseRepo.saveAll(landSenseList);
    }
}
