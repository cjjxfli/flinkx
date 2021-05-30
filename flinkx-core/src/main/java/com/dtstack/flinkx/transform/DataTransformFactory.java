package com.dtstack.flinkx.transform;

import com.dtstack.flinkx.classloader.ClassLoaderManager;
import com.dtstack.flinkx.classloader.PluginUtil;
import com.dtstack.flinkx.config.DataTransferConfig;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Set;

/**
 * Created by lxf20054658@163.com on 2021/5/30.
 */
public class DataTransformFactory {

    public DataTransformFactory(){}
    public static BaseDataTransform getDataTransform(DataTransferConfig config, StreamExecutionEnvironment env) {
        try {
            String pluginName = config.getJob().getContent().get(0).getTransform().getName();
            String pluginClassName = PluginUtil.getPluginClassName(pluginName);
            Set<URL> urlList = PluginUtil.getJarFileDirPath(pluginName, config.getPluginRoot(), null);

            return ClassLoaderManager.newInstance(urlList, cl -> {
                Class<?> clazz = cl.loadClass(pluginClassName);
                Constructor constructor = clazz.getConstructor(DataTransferConfig.class, StreamExecutionEnvironment.class);
                return (BaseDataTransform)constructor.newInstance(config, env);
            });
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
