package org.apache.spark.streaming.kinesis;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessorFactory;

/**
 * Adapts a V1 {@link com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory
 * IRecordProcessorFactory} to V2
 * {@link com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessorFactory IRecordProcessorFactory}.
 */
class V1ToV2RecordProcessorFactoryAdapter implements IRecordProcessorFactory {

    private com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory factory;

    V1ToV2RecordProcessorFactoryAdapter(
            com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory factory) {
        this.factory = factory;
    }

    @Override
    public IRecordProcessor createProcessor() {
        return new V1ToV2RecordProcessorAdapter(factory.createProcessor());
    }
}
