import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.*;

/**
 * @author pengganyu
 * @version V1.0 2018/6/28 pengganyu Exp $
 */

public class FreemarkerUtil {

    /**
     * 根据数据和模板名称创建文件
     * @param obj
     * @param templateName
     * @param fileName
     * @return
     */
    public static File createExcel(Object obj, String templateName, String fileName) {
        File file = getFile(fileName);

        Template template = getTemplate(templateName);

        renderFile(obj, template, file);

        return file;
    }

    /**
     * 创建文件
     * @param fileName
     * @return
     */
    private static File getFile(String fileName) {
        File file = new File(
            System.getProperty("java.io.tmpdir") + File.separator + fileName + ".xlsx");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    /**
     * 根据模板名称获取模板配置信息
     * @param templateName
     * @return
     */
    private static Template getTemplate(String templateName) {
        try {
            return new FreemarkerConfig().getConfiguration().getTemplate(templateName);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 渲染文件
     * @param obj
     * @param template
     * @param file
     */
    private static void renderFile(Object obj, Template template, File file) {
        try {
            Writer w = new OutputStreamWriter(new FileOutputStream(file), "utf-8");
            template.process(obj, w);
            w.close();
        } catch (TemplateException | IOException e) {
            e.printStackTrace();
        }

    }

}
