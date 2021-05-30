package com.dtstack.flinkx.transform.substr;

import com.dtstack.flinkx.transform.BaseDataTransform;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.types.Row;

/**
 * Created by Administrator on 2021/5/30.
 */
public class SubstrTransformer extends BaseDataTransform {
    @Override
    public DataStream<Row> transformData(DataStream<Row> inputData, Object... paras) {
        return null;
    }
}
