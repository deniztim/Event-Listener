call atlas-mvn package -o -DskipTests
call atlas-install-plugin --username admin --password 123 --plugin-key com.example.plugins.tutorial -p 8080 --server localhost --context-path 