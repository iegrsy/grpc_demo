package iegrsy.space;

import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ptzp.PTZServiceGrpc;
import ptzp.Ptzp;

public class Demo {

    public static void main(String[] args) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress("0.0.0.0", 2222).usePlaintext().build();
        PTZServiceGrpc.PTZServiceBlockingStub blockingStub = PTZServiceGrpc.newBlockingStub(channel);
        try {
            Ptzp.PtzHeadInfo headInfo = blockingStub.getHeads(Empty.newBuilder().build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
