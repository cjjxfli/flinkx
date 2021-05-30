package com.dtstack.flinkx.config;

import java.util.List;
import java.util.Map;

/**
 * Created by lxf20054658@163.com on 2021/5/30.
 */
public class TransformConfig extends AbstractConfig {
    public static String KEY_PARAMETER_CONFIG = "parameter";
    public static String KEY_WRITER_NAME = "name";

    ParameterConfig parameter;

    public TransformConfig(Map<String, Object> map) {
        super(map);
        parameter = new ParameterConfig((Map<String, Object>) getVal(KEY_PARAMETER_CONFIG));
    }

    public String getName() {
        return getStringVal(KEY_WRITER_NAME);
    }

    public void setName(String name) {
        setStringVal(KEY_WRITER_NAME, name);
    }

    public ParameterConfig getParameter() {
        return parameter;
    }

    public void setParameter(ParameterConfig parameter) {
        this.parameter = parameter;
    }
    public static class ParameterConfig extends AbstractConfig {
        public static final String KEY_COLUMN_LIST = "column";
        List column;

        public ParameterConfig(Map<String, Object> map) {
            super(map);
            column = (List) getVal(KEY_COLUMN_LIST);
        }
    }
}
