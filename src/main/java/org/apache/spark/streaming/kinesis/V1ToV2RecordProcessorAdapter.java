package org.apache.spark.streaming.kinesis;

import com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor;
import com.amazonaws.services.kinesis.clientlibrary.types.InitializationInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ProcessRecordsInput;
import com.amazonaws.services.kinesis.clientlibrary.types.ShutdownInput;

/**
 * Adapts a V1 {@link com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessor IRecordProcessor}
 * to V2 {@link com.amazonaws.services.kinesis.clientlibrary.interfaces.v2.IRecordProcessor IRecordProcessor}.
 */
class V1ToV2RecordProcessorAdapter implements IRecordProcessor {

    private com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessor recordProcessor;

    V1ToV2RecordProcessorAdapter(
            com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessor recordProcessor) {
        this.recordProcessor = recordProcessor;
    }

    @Override
    public void initialize(InitializationInput initializationInput) {
        recordProcessor.initialize(initializationInput.getShardId());
    }

    @Override
    public void processRecords(ProcessRecordsInput processRecordsInput) {
        recordProcessor.processRecords(processRecordsInput.getRecords(), processRecordsInput.getCheckpointer());

    }

    @Override
    public void shutdown(ShutdownInput shutdownInput) {
        recordProcessor.shutdown(shutdownInput.getCheckpointer(), shutdownInput.getShutdownReason());
    }

}
