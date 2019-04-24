# Proto compile and GRPC sample code

## *Proto Compile*

Proto dosyalarının derlenmesi ve jar kütüphanesi oluşturulması.

```sh
./gradlew assemble
```

## *GRPC Test*

Bağlantı testi için kafa bilgisi çağrılıyor.  

> rpc GetHeads(google.protobuf.Empty) returns (PtzHeadInfo) {}

```sh
#./gradlew execute --args='<host> <port>'

./gradlew execute --args='10.5.179.29 50058'
```

Çalışan kod bloğu

```java
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
``` 
