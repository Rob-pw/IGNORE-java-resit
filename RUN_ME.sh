find ./src/ -name "*.java" > sources.txt
now=$(date +"%T")
echo "Current time : $now"
javac -d ./bin/ @sources.txt
java --class-path="./bin/" MainApp
