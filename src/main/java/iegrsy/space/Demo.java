package iegrsy.space;

import com.google.protobuf.Empty;

import java.security.InvalidParameterException;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import ptzp.PTZServiceGrpc;
import ptzp.Ptzp;

public class Demo {

    public static void main(String[] args) {
        try {
            if (args.length < 2)
                throw new InvalidParameterException("Sample use ./gradlew execute --args='<host> <port>'");

            ManagedChannel channel = ManagedChannelBuilder.forAddress(args[0], Integer.parseInt(args[1])).usePlaintext().build();
            PTZServiceGrpc.PTZServiceBlockingStub blockingStub = PTZServiceGrpc.newBlockingStub(channel);

            Ptzp.PtzHeadInfo headInfo = blockingStub.getHeads(Empty.newBuilder().build());
            System.out.println(headInfo.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
