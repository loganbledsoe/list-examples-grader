CPATH='.;lib/hamcrest-core-1.3.jar;lib/junit-4.13.2.jar'

rm -rf student-submission
rm -rf grading-area

mkdir grading-area

git clone $1 student-submission > /dev/null 2>&1

if [[ $? -eq 0 ]];
then
    echo 'Sucessfully cloned repository'
else
    echo 'Repository not found!'
    echo ''
    echo 'FAIL'
    exit
fi

if [[ -f student-submission/ListExamples.java ]];
then
    echo 'File ListExamples.java found'
else
    echo 'File not found!'
    echo ''
    echo 'FAIL'
    exit
fi

cp student-submission/ListExamples.java TestListExamples.java grading-area
cp -r lib grading-area

cd grading-area

javac -cp $CPATH *.java > /dev/null 2>&1

if [[ $? -eq 0 ]];
then
    echo 'Sucessfully compiled'
else
    echo 'Unable to compile!'
    echo ''
    echo 'FAIL'
    exit
fi

java -cp $CPATH org.junit.runner.JUnitCore TestListExamples > output.txt

if [[ $? -eq 0 ]];
then
    echo 'All tests passed'
    echo ''
    echo 'PASS'
    exit
fi


# Draw a picture/take notes on the directory structure that's set up after
# getting to this point

# Then, add here code to compile and run, and do any post-processing of the
# tests

tail -n 2 output.txt | head -n 1
echo ''
echo 'FAIL'
