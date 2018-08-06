import freemarker.template.Configuration;

import java.io.File;
import java.io.IOException;

/**
 * Freemarker的配置，Configuration需要使用单例
 * @author pengganyu
 * @version V1.0 2018/6/28 pengganyu Exp $
 */
public class FreemarkerConfig {
    private final String  templatePath = "template";
    private Configuration configuration;

    /**
     * 获取freemarker的config
     * @return
     */
    public Configuration getConfiguration() {
        if (configuration == null) {
            return initConfiguration();
        }
        return configuration;
    }

    /**
     * init freemarker config
     * @return
     */
    public Configuration initConfiguration() {
        configuration = new Configuration(Configuration.VERSION_2_3_19);
        configuration.setDefaultEncoding("UTF-8");
        try {
            configuration.setDirectoryForTemplateLoading(new File(
                this.getClass().getResource("/").getPath() + File.separator + templatePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return configuration;
    }

}
