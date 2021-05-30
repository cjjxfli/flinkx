package com.dtstack.flinkx.transform;

import com.dtstack.flinkx.config.DataTransferConfig;
import com.dtstack.flinkx.config.LogConfig;
import com.dtstack.flinkx.config.RestoreConfig;
import com.dtstack.flinkx.config.TestConfig;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.types.Row;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lxf20054658@163.com on 2021/5/30.
 */
public abstract class BaseDataTransform {
    protected StreamExecutionEnvironment env;

    protected int numPartitions = 1;

    protected long bytes = Long.MAX_VALUE;

    protected String monitorUrls;

    protected RestoreConfig restoreConfig;

    protected LogConfig logConfig;

    protected TestConfig testConfig;

    protected List<String> srcCols = new ArrayList<>();

    protected long exceptionIndex;

    protected DataTransferConfig dataTransferConfig;
    protected String transformerName;

    /**
     * 转换可以串行
     * @param inputData
     * @param paras
     * @return
     */
    public abstract DataStream<Row> transformData(DataStream<Row> inputData,Object... paras);
}
