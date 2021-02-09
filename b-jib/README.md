# Add ca-certificate

    cd b-jib/
    docker run -v $PWD:/data   -it azul/zulu-openjdk:11
    keytool -import -cacerts  -noprompt -alias anthonycert -file /data/src/main/jib/ca-certificates/AnthonyOrganization.crt
    keytool -list -cacerts
    cp /usr/lib/jvm/zulu11/lib/security/cacerts /data/src/main/jib/ca-certificates/cacerts.jks

# Build the project

     ./mvnw compile jib:build  