all:
	if [ ! -d "./proto_gen" ]; then mkdir proto_gen; fi
	protoc -I ./ --java_out ./proto_gen --plugin=protoc-gen-grpc-java=protoc-gen-grpc-java --grpc-java_out ./proto_gen *.proto
clean:
	rm -rf ./proto_gen/