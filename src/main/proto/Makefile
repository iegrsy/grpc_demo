all:
	protoc -I ./ --java_out ./ --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java --grpc-java_out ./ *.proto
clean:
	rm -rf OrionCommunication/ ptzp/